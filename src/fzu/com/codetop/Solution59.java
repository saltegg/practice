package fzu.com.codetop;

public class Solution59 {

    public static int[][] generateMatrix(int n) {

            int[][] res = new int[n][n];
            int c = 1, top = 0, bottom = n - 1, left = 0, right = n - 1;
            while (true) {
                for (int i = left; i <= right; i++) {
                    res[top][i] = c++;
                }
                if (++top > bottom) break;
                for (int i = top; i<= bottom; i++) {
                    res[i][right] = c++;
                }
                if (--right < left) break;
                for (int i = right; i >= left; i--) {
                    res[bottom][i] = c++;
                }
                if (--  bottom < top) break;
                for (int i = bottom; i >= top; i--) {
                    res[i][left] = c++;
                }
                if (++left > right) break;
            }
            return res;
    }

    public static void main(String[] args) {
        generateMatrix(3);
    }
}
