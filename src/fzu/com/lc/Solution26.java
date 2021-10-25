package fzu.com.lc;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[k] != nums[i]) {
                   nums[++k] = nums[i];
                }
            }
        }
        return k + 1;
    }
}
