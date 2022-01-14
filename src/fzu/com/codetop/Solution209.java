package fzu.com.codetop;

public class Solution209 {

    public int minSubArrayLen(int target, int[] nums) {

        int sum = 0, res = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target && l <= r) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
