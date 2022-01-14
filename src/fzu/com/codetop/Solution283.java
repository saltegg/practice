package fzu.com.codetop;

public class Solution283 {

    public void moveZeroes(int[] nums) {

        int k = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt++;
            } else {
                nums[k++] = nums[i];
            }
        }
        while (cnt-- > 0) {
            nums[k++] = 0;
        }
    }
}
