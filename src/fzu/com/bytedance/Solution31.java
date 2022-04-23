package fzu.com.bytedance;

import java.util.Arrays;

public class Solution31 {

    public void nextPermutation(int[] nums) {

        int p = 0, k = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) p = i;
        }
        for (int i = p + 1; i < nums.length; i++) {
            if (nums[i] > nums[p]) k = i;
        }
        swap(nums, p, k);
        Arrays.sort(nums, p + 1, nums.length);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
