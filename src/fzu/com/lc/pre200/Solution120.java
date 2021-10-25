package fzu.com.lc.pre200;

import java.util.List;

public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        int len = triangle.size();
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);

            }
        }
        return dp[0][0];
    }
}
