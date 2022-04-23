package fzu.com.bytedance;

public class Solution300 {

    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if (len <= 1) return 1;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (dp[k] < nums[i]) {
                dp[++k] = nums[i];
            } else {
                int l = 0, r = k;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (dp[mid] <= nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                dp[l] = nums[i];
            }
        }
        return k + 1;
    }
}
