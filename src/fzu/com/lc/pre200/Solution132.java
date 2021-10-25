package fzu.com.lc.pre200;

public class Solution132 {

    public static int minCut(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[j + 1][i - 1]);

            }
        }

        int[] f = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                f[i] = i;
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[s.length() - 1];
    }

    public static void main(String[] args) {
        minCut("aab");
    }
}
