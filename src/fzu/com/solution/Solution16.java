package fzu.com.solution;

import java.util.Arrays;

public class Solution16 {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int res = 10000;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}
