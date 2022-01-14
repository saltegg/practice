package fzu.com.codetop;

public class Solution322 {

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= amount; i++) dp[0][i] = -1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
                for (int k = 0; k * coins[i - 1] <= j; k++) {
                    if (dp[i - 1][j - k * coins[i - 1]] != -1) {
                        if (dp[i][j] == - 1) {
                            dp[i][j] = dp[i - 1][j - k * coins[i - 1]] + k;
                        } else {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i - 1]] + k);
                        }
                    }
                }
            }
        }
        return dp[coins.length][amount];
    }
}
