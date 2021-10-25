package fzu.com.lc.pre200;

import java.util.Arrays;

public class Solution673 {

    public static int findNumberOfLIS(int[] nums) {
        int maxLen = 0, ans = 0;
        int[] dp = new int[nums.length];
        int[] combination = new int[nums.length];
        Arrays.fill(combination, 1);
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    //dp[i] = Math.max(dp[j] + 1, dp[i]);
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        combination[i] = combination[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        combination[i] += combination[j];
                    }
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        for (int i = 0; i < nums.length; i++) {
            if (maxLen == dp[i]) ans += combination[i];
        }
        return ans;
    }

}
