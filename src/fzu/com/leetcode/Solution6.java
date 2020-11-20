package fzu.com.leetcode;


// 最长回文子串 动态规划
public class Solution6 {

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int n = s.length();
        int l = 0, r = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j  < 3 || dp[j + 1][i - 1]);
                if (dp[j][i] && r - l < i - j) {
                    r = i;
                    l = j;
                }
            }
        }
        return s.substring(l, r + 1);
    }
}
