package fzu.com.solution;

public class Solution05 {

    public String longestPalindrome(String s) {

        int n = s.length(), l = 0, r = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[j + 1][i - 1]);
                if (dp[j][i] && i - j > r - l) {
                    r = i;
                    l = j;
                }
            }
        }
        return s.substring(l, r + 1);
    }
}
