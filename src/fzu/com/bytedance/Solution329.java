package fzu.com.bytedance;

public class Solution329 {

    private int[] dir = {-1, 0, 1, 0, -1};
    private int[][] dp;

    private int dfs(int m, int n, int x, int y, int[][] matrix, int preNum) {
        if (x >= m || x < 0 || y >= n || y < 0) return 0;
        if (matrix[x][y] <= preNum) return 0;
        if (dp[x][y] > 0) return dp[x][y];
        int max = 0;
        for (int i = 0; i < 4; i++) {
            int r = x + dir[i];
            int c = y + dir[i + 1];
            max = Math.max(max, dfs(m, n, r, c, matrix, matrix[x][y]));
        }
        dp[x][y] = 1 + max;
        return 1 + max;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    dp[i][j] = dfs(m, n, i, j, matrix, -1);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
