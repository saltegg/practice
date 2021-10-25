package fzu.com.lc.pre200;

public class Solution05 {

    public String longestPalindrome(String s) {

        int res = Integer.MIN_VALUE, l = 0, r = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[j + 1][i - 1]);
                if (dp[j][i] && i - j + 1 > res) {
                    res = i - j + 1;
                    l = j;
                    r = i;
                }
            }
        }
        return s.substring(l, r + 1);
    }
}
