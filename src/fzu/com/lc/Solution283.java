package fzu.com.lc;

public class Solution283 {

    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        while (k < nums.length) nums[k++] = 0;
    }

    public static void main(String[] args) {

    }
}
