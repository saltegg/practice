package fzu.com.codetop;

public class Solution200 {

    public int numIslands(char[][] grid) {

        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return res;
    }

    private final int[] dir = {-1, 0, 1, 0, -1};

    private void dfs(char[][] grid, int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') return;
        grid[x][y] = '0';
        for (int k = 0; k < 4; k++) {
            int r = x + dir[k];
            int c = y + dir[k + 1];
            dfs(grid, r, c, m, n);
        }
    }
}
