package fzu.com.lc.pre200;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {

    public List<List<Integer>> generate(int numRows) {

        int[][] matrix = new int[numRows][numRows];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) matrix[i][j] = 1;
                else matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
            }
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> rowRes = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                rowRes.add(matrix[i][j]);
            }
            res.add(rowRes);
        }
        return res;
    }
}
