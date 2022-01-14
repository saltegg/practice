package fzu.com.codetop;

public class Solution240 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length;
        int t = 0, b = m - 1;
        while (t < b) {
            int mid = t + (b - t) / 2;
            if (matrix[mid][n - 1] == target) {
                return true;
            } else if (matrix[mid][n - 1] > target) {
                b = mid;
            } else {
                t = mid + 1;
            }
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[l][mid] == target) {
                return true;
            } else if (matrix[l][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
