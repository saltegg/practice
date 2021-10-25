package fzu.com.lc.pre200;

public class Solution516 {

    public int longestPalindromeSubseq(String s) {

        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (i - j == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[j][i] = 2;
                    }
                    else {
                        dp[j][i] = 1;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[j][i] =
                                Math.max(dp[j + 1][i - 1] + 2, Math.max(dp[j][i - 1], dp[j + 1][i]));
                    }
                    else {
                        dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]);
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
