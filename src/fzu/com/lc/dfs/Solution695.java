package fzu.com.lc.dfs;

public class Solution695 {

    private int[] dir = {-1, 0, 1, 0, -1};

    public int dfs1(int[][] grid, int x, int y) {
       if (grid[x][y] == 0) return 0;
       grid[x][y] = 0;
       int r, c, areas = 1;
       for (int i = 0; i < 4; i++) {
           r = x + dir[i];
           c = y + dir[i + 1];
           if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
                areas += dfs1(grid, r, c);
           }
       }
       return areas;
    }

    public int dfs2(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length && y < 0 || y >= grid[0].length || grid[x][y] == 0) return 0;
        grid[x][y] = 0;
        return 1 +
                dfs2(grid, x - 1, y) +
                dfs2(grid, x + 1, y) +
                dfs2(grid, x, y - 1) +
                dfs2(grid, x, y + 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(dfs2(grid, i, j), max);
                }
            }
        }
        return max;
    }
}
