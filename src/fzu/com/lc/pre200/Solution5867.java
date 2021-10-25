package fzu.com.lc.pre200;

import java.util.HashMap;
import java.util.Map;

public class Solution5867 {

    public String reversePrefix(String word, char ch) {

        int idx = word.indexOf(ch);
        if (idx == -1) return word;
        StringBuilder stringBuilder = new StringBuilder(word.substring(0, idx + 1));
        stringBuilder.reverse().append(word.substring(idx + 1, word.length()));
        return stringBuilder.toString();
    }

    public long interchangeableRectangles(int[][] rectangles) {

        long ans = 0;
        Map<Double,Integer> map = new HashMap<>();
        for (int[] rectangle : rectangles) {
            Double rate = rectangle[0] * 1.0 / rectangle[1];
            if (map.containsKey(rate)) {
                map.put(rate, map.get(rate) + 1);
            } else {
                map.put(rate, 1);
            }
        }
        for (Double r : map.keySet()) {
            int cnt = map.get(r);
            if (cnt > 1) {
                ans += (long) cnt * (cnt - 1) / 2;
            }
        }
        return ans;
    }

    int max = Integer.MIN_VALUE;

    private void dfs(String s, int pos, String a, String b) {
        if (check(a) && check(b)) {
            max = Math.max(max, a.length() * b.length());
        }
        if (pos == s.length()) return;
        dfs(s, pos + 1, a + s.charAt(pos), b);
        dfs(s, pos + 1, a, b + s.charAt(pos));
        dfs(s, pos + 1, a, b);
    }

    private boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public int maxProduct(String s) {
        dfs(s, 0, "", "");
        return max;
    }

}
