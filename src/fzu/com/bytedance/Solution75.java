package fzu.com.bytedance;

public class Solution75 {

    public void sortColors(int[] nums) {

        int l = 0, r = nums.length - 1, i = 0;

        while (i <= r){
            if (nums[i] == 0) {
                swap(l++, i++, nums);
            } else if (nums[i] == 2) {
                swap(i, r--, nums);
            } else {
                i++;
            }
        }

    }

    public void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
