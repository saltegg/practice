package fzu.com.lc.pre200;

public class Solution650 {

    public int minSteps(int n) {

        int[] dp = new int[n + 2];
        dp[1] = 0;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 1) {
                int tmp = 0;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        tmp = j;
                        break;
                    }
                }
                dp[i] = tmp > 0? dp[i / tmp] + tmp : i;
            } else {
                dp[i] = dp[i / 2] + 2;
            }
        }
        return dp[n];
    }
}
