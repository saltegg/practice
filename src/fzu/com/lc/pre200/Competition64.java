package fzu.com.lc.pre200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Competition64 {

    public String kthDistinct(String[] arr, int k) {

        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        for (String str : arr) {
            int t = map.getOrDefault(str,  0);
            if (t == 0) {
                map.put(str, 1);
            } else {
                map.put(str, t + 1);
            }
        }
        for (String str : arr) {
            int t = map.get(str);
            if (t == 1) {
                cnt++;
            }
            if (cnt == k) return str;
        }
        return "";
    }

    public int maxTwoEvents(int[][] events) {
        int max = 0;
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]); // 按照开始时间从升序排列
        int[] nextBig = new int[events.length + 1];
        for (int i = events.length - 1; i >= 0; i--) {
            nextBig[i] = Math.max(nextBig[i + 1], events[i][2]); // 排序后第i个事件右边最大的value
        }
        for (int[] event : events) {
            int idx = biSearch(events, event[1]); 
            int sum = event[2] + nextBig[idx];
            max = Math.max(max, sum);
        }
        return max;
    }

    private int biSearch(int[][] events, int target) {
        int l = 0, r = events.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (events[mid][0] > target){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {

        int[] res = new int[queries.length];
        int[] dp = new int[s.length()]; // 表示第i个字符(包括i本身)的右边有多少个蜡烛
        int[] dp1 = new int[s.length()]; // 对于第i个字符左边最近的蜡烛下标
        int[] dp2 = new int[s.length()]; // 对于第i个字符右边最近的蜡烛下标

        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                if (s.charAt(i) == '*') {
                    dp1[i] = dp1[i - 1];
                } else {
                    dp1[i] = i;
                }
            } else {
                if (s.charAt(i) == '*') {
                    dp1[i] = -1;
                } else {
                    dp1[i] = i;
                }
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i < s.length() - 1) {
                if (s.charAt(i) == '*') {
                    dp2[i] = dp2[i + 1];
                    dp[i] = dp[i + 1];
                } else {
                    dp2[i] = i;
                    dp[i] = dp[i + 1] + 1;
                }
            } else {
                if (s.charAt(i) == '*') {
                    dp2[i] = s.length();
                    dp[i] = 0;
                } else {
                    dp2[i] = i;
                    dp[i] = 1;
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int cnt = 0;
            int l = queries[i][0], r = queries[i][1];
            int a = dp2[l], b = dp1[r];
            if (a < b) {  // 如果a < b,说明有*在|...|之间a是左边蜡烛的下标，b是右边蜡烛的下标
                cnt = b - a - 1; // 两根蜡烛中间有多少个字符
                cnt -= dp[a] - dp[b] - 1; // 再扣除两根蜡烛之间的蜡烛
            }
            res[i] = cnt;
        }
        return res;
    }

}
