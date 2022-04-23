package fzu.com.bytedance;

public class Solution189 {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        revers(nums, 0, nums.length - 1);
        revers(nums, 0, k - 1);
        revers(nums, k, nums.length - 1);
    }

    private void revers(int[] nums, int s, int e) {
        while (s < e) {
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
            s++;
            e++;
        }
    }
}
