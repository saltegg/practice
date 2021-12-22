package fzu.com.codetop;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0, bottom = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][r]);
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return res;
    }
}
