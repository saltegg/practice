package fzu.com.lc.pre200;

public class Competition260 {

    public int maximumDifference(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, nums[j] - nums[i]);
                }
            }
        }
        return max == Integer.MIN_VALUE? -1 : max;
    }

    public long gridGame(int[][] grid) {

        long[][] dp1 = new long[2][grid[0].length];
        long[][] dp2 = new long[2][grid[0].length];
        dp1[0][0] = grid[0][0];
        for (int i = 1; i < 2; i++) {
            dp1[i][0] = dp1[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp1[0][j] = dp1[0][j - 1] + grid[0][j];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp1[1][j] = Math.max(dp1[0][j], dp1[1][j - 1]) + grid[1][j];
        }

        int ii = 1, jj = grid[0].length - 1;
        while (ii != 0 && jj != 0) {
            if (dp1[0][jj] > dp1[1][jj - 1]) {
                grid[0][jj] = 0;
                ii--;
            } else {
                grid[1][jj - 1] = 0;
                jj--;
            }
        }
        if (ii == 0) {
            while (jj-- >0){
                grid[0][jj] = 0;
            }
        }

        grid[0][0] = 0;
        grid[1][grid[0].length - 1] = 0;
        dp2[0][0] = 0;
        for (int i = 1; i < 2; i++) {
            dp2[i][0] = dp2[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp2[0][j] = dp2[0][j - 1] + grid[0][j];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp2[1][j] = Math.max(dp2[0][j], dp2[1][j - 1]) + grid[1][j];
        }
        return dp2[1][grid[0].length - 1];
    }
}
