package fzu.com.lc.dfs;

import java.util.ArrayList;
import java.util.List;

public class Solution417 {

    private static int[] dir = {-1, 0, 1, 0, -1};

    private static void dfs(int[][] matrix, int n, int m, int x, int y, int preHigh,
                            boolean[][] canReach) {
        if (x < 0 || x >= n || y < 0 || y >= m) return;
        if (matrix[x][y] < preHigh || canReach[x][y]) return;
        canReach[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int r = x + dir[i];
            int c = y + dir[i + 1];
            dfs(matrix, n, m, r, c, matrix[x][y], canReach);
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> res = new ArrayList<>();
        if (null == matrix || matrix.length == 0) return res;

        boolean[][] canReachAtlantic= new boolean[151][151];  // 大西洋
        boolean[][] canReachPacific= new boolean[151][151];   // 太平洋
        int n = matrix.length, m = matrix[0].length;

        for (int i = 0; i < m; i++) {
            dfs(matrix, n, m, 0, i, 0, canReachAtlantic);
            dfs(matrix, n, m, n - 1, i, 0, canReachPacific);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, n, m, j, 0, 0, canReachAtlantic);
            dfs(matrix, n, m, j, m - 1, 0, canReachPacific);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canReachAtlantic[i][j] && canReachPacific[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
