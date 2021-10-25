package fzu.com.lc.pointOffer;

public class Offer42 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]; // dp[i]表示以i个数为结尾的子数组的最大值
        int ans = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
