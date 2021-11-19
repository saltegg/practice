package fzu.com.lc.pre200;

public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                int l = 0, r = col;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (matrix[row][mid] == target) return true;
                    else if (matrix[row][mid] > target) r = mid - 1;
                    else l = mid + 1;
                }
                return false;
            }
        }
        return false;
    }
}
