package fzu.com.codetop;

/**
 * @Author: linxiaohui
 * @Date: 2022/01/23 15:06
 * @Description:
 */
public class Solution329 {

    private int res = 0;
    private int[] dir = {-1, 0, 1, 0, -1};
    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (memo[i][j] == 0) {
                    dfs(matrix, i, j, m, n);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int x, int y, int m, int n) {

        if (memo[x][y] > 0) return memo[x][y];
        int t = 0;
        for (int k = 0; k < 4; k++) {
            int r = x + dir[k];
            int c = y + dir[k + 1];
            if (r >= 0 && r < m && c >= 0 && c < n && matrix[x][y] < matrix[r][c]) {
                t = Math.max(t, dfs(matrix, r, c, m, n));
            }
        }
        memo[x][y] = 1 + t;
        res = Math.max(res, memo[x][y]);
        return memo[x][y];
    }
}
