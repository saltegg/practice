package fzu.com.bytedance;

import java.util.Map;

public class Solution32 {

    public int longestValidParentheses(String s) {

        if (s == null || s.length() == 0) return 0;
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int l = i - dp[i - 1] -1;
            if (s.charAt(i) == ')' && l >= 0 && s.charAt(l) == '(') {
                dp[i] = dp[i - 1] +2;
                if (l > 1) {
                    dp[i] += dp[l - 1];
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
