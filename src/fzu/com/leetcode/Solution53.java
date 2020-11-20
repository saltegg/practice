package fzu.com.leetcode;

public class Solution53 {

    /**
     * 动态规划
     * 定义一个函数f(n)，以第n个数为结束点的子数列的最大和，
     * 存在一个递推关系f(n) = max(f(n-1) + A[n], A[n]);
     * [-2,1,-3,4,-1,2,1,-5,4]
     * 连续子数组 [4,-1,2,1] 的和最大，为 6
     */

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
            System.out.println(dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        //maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
