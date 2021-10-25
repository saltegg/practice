package fzu.com.lc.dp;

public class Solution198 {

    public static int rob2(int[] nums) {

        if (nums.length == 0) return 0;

        int a = nums[0], b = 0;
        for (int i = 2; i <= nums.length; i++) {
            int tmp = a;
            a = Math.max(a, b + nums[i - 1]);
            b = tmp;
        }
        return a;
    }

    public int rob1(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {

    }
}
