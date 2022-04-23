package fzu.com.solution.bi;

public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][n - 1] == target) {
                return true;
            } else if (matrix[mid][n - 1] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l >= m) return false;
        int t = l;
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[t][mid] == target) {
                return true;
            } else if (matrix[t][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
