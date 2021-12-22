package fzu.com.codetop;

public class Solution5 {

    public String longestPalindrome(String s) {
        int len = s.length(), l = 0, r = 0;
        boolean[][] dp = new boolean[len + 1][len + 1];
        for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[j + 1][i - 1]);
                if (dp[j][i] && i - j + 1 > r - l + 1) {
                    l = j;
                    r = i;
                }
            }
        }
        return s.substring(l, r + 1);
    }
}
