package fzu.com.lc.pre200;

import java.util.Arrays;

public class Solution5588 {


    public int minimumDifference(int[] nums, int k) {

        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (r - l + 1 == k) {
                res = Math.min(res, nums[r] - nums[l]);
                l++;
            }
        }
        return res;

    }

}
