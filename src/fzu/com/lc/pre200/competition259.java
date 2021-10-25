package fzu.com.lc.pre200;

import java.util.HashMap;
import java.util.Map;

public class competition259 {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations) {
            switch (op) {
                case "--X":
                    --x;
                    break;
                case "X--":
                    x--;
                    break;
                case "X++":
                    x++;
                    break;
                default:
                    ++x;
                    break;
            }
        }
        return x;
    }

    public int sumOfBeauties(int[] nums) {

        int b = 0;
        int[] leftMax = new int[nums.length];
        int[] rightMin = new int[nums.length];
        leftMax[0] = nums[0];
        rightMin[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(nums[i - 1], leftMax[i - 1]);
        }
        for (int i = rightMin.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(nums[i + 1], rightMin[i + 1]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] < rightMin[i] && nums[i] > leftMax[i]) {
                b += 2;
            } else if (nums[i] < nums[i + 1] && nums[i] > nums[i - 1]) {
                b += 1;
            }
        }
        return b;
    }

    private Map<String, Integer> map;

    public void DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {

        int count = 0;
        for (String key : map.keySet()) {
            String[] p = key.split(",");
            int x = Integer.parseInt(p[0]);
            int y = Integer.parseInt(p[1]);
            if (x != point[0] && y != point[1] && Math.abs(x - point[0]) == Math.abs(y - point[1])) {
                String a = x + "," + point[1];
                String b = point[0] + "," + y;
                if (map.containsKey(a) && map.containsKey(b)) {
                    count += map.get(key) * map.get(a) * map.get(b);
                }
            }
        }
        return count;
    }

    // 全排列候选人
    StringBuilder ans = new StringBuilder();
    boolean[] used = new boolean[10];

    // 检查当前排列是不是满足 s 中 k 次子序列
    private boolean check(char[] s, int n, int k) {
        int cnt = 0, idx = 0;
        for (char ch : s) {
            if (ch == ans.charAt(idx)) {
                idx++;
                if (idx == n) {
                    idx = 0;
                    cnt++;
                }
            }
        }
        return cnt >= k;
    }

    // 生成 p 的的全排列，最终检查是不是满足
    private boolean dfs(char[] s, char[] p, int cur, int cnt, int n, int k) {
        if (cur == cnt) {
            return check(s, n, k);
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                ans.append(p[i]);
                if (dfs(s, p, cur + 1, cnt, n, k)) {
                    return true;
                }
                ans.deleteCharAt(cur);
                used[i] = false;
            }
        }
        return false;
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] hash = new int[26];
        char[] arr = s.toCharArray();

        // 计数
        for (char ch : arr) {
            hash[ch - 'a']++;
        }

        // 按逆序字典序，将满足 k 次的字符加入
        // 如果一个字母频率为f，那么其可能参与组成的子串最多为f/k个(整数除法)
        StringBuilder sb = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < hash[i] / k; j++) {
                sb.append((char) ('a' + i));
            }
        }

        // 搜索 i = n -> 1 长度的全排列，找第一个满足的
        int n = sb.length();
        char[] pattern = sb.toString().toCharArray();
        for (int i = n; i > 0; i--) {
            if (dfs(arr, pattern, 0, i, n, k)) {
                return ans.toString();
            }
        }

        return "";
    }
}
