package fzu.com.lc.pre200;

public class Solution41 {

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int len = nums.length;
        while (i < len) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            i++;
        }
        for (i = 0; i < len; i++) {
            if (nums[i] - 1 != i) return nums[i];
        }
        return len + 1;
    }
}
