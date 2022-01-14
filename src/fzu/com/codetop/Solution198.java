package fzu.com.codetop;

import java.util.Map;

public class Solution198 {

    public int rob(int[] nums) {

        int[] dp = new int[nums.length];
        int[] track = new int[nums.length];

        if (nums.length == 1) {
            dp[0] = nums[0];
        }
        if (nums.length >= 2) {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < nums.length; i++) {
            if (dp[i - 2] + nums[i] > dp[i - 1]) {
                dp[i] = dp[i - 2] + nums[i];
                track[i] = 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        int i = nums.length - 1;
        while (i > 0) {
            if (track[i] == 1) {
                System.out.print(nums[i] + " ");
                i -= 2;
            } else {
                i--;
            }
            if (i < 2) break;
        }
        if (i == 1) System.out.print(Math.max(nums[i], nums[i - 1]));
        else System.out.print(nums[i]);
        return dp[nums.length - 1];
    }
}
