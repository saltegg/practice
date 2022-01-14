package fzu.com.codetop;

public class Solution498 {

    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int flag = 0, x = 0, y = 0, k = 0;

        while (true) {
            res[k++] = mat[x][y];
            if (x == m - 1 && y == n - 1) break;
            if (flag == 0) {
                if (x - 1 >= 0 && y + 1 < n) {
                    x--;
                    y++;
                } else {
                    if (y + 1 == n) {
                        x++;
                    } else {
                        y++;
                    }
                    flag = 1;
                    continue;
                }
            }
            if (flag == 1) {
                if (x + 1 < m && y - 1 >= 0) {
                    x++;
                    y--;
                } else {
                    if (x + 1 == m) {
                        y++;
                    } else {
                        x++;
                    }
                    flag = 0;
                }
            }
        }
        return res;
    }
}
