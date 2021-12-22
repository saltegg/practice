package fzu.com.codetop;

import java.util.Arrays;

public class Solution31 {

    public void nextPermutation(int[] nums) {

        int l = 0, r = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <nums[i + 1]) {  // 找到最后一对升序， 如果没有一对升序，就直接整个逆序就行了
                l = i;
            }
        }
        for (int i = l + 1; i < nums.length; i++) {
            if(nums[i] > nums[l]) {  // 找到最后一个大于nums[l]的那一个， 也是大于它中最小的一个
                r = i;
            }
        }
        swap(nums, l, r);
        Arrays.sort(nums, l + 1, nums.length);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
