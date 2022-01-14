package fzu.com.codetop;

public class Solution32 {

    public int longestValidParentheses(String s) {

        if (s == null || s.length() == 0) return 0;
        int ans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int left = i - dp[i - 1] - 1;
            if (s.charAt(i) == ')' && left >= 0 && s.charAt(left) == '(') {
                dp[i] = dp[i - 1] + 2;
                if (left > 1) {
                    dp[i] += dp[left - 1];
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return dp[s.length() - 1];
    }
}
