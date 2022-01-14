package fzu.com.codetop;

public class Solution64 {

        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] dp =new int[n + 1];
            for (int i = 1; i <= n; i++) dp[i] = dp[i - 1] + grid[0][i - 1];
            for (int i = 1; i < m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j == 1) {
                        dp[j] = dp[j - 1] + grid[i][j - 1];
                    } else {
                        dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j - 1];
                    }
                }
            }
            return dp[n];
        }
}
