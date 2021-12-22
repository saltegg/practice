package fzu.com.codetop;

public class Solution215 {

    private int pp(int[] nums, int l, int r) {
        int tmp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= tmp) r--;
            if (l < r) nums[l] = nums[r];
            while (l < r && nums[l] < tmp) l++;
            if (l < r) nums[r] = nums[l];
        }
        nums[l] = tmp;
        return l;
    }

    public int findKthLargest(int[] nums, int k) {

        int target = nums.length - k;  // 目标的index
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int partition = pp(nums, l, r);
            if (partition == target) {
                return nums[partition];
            } else if (partition > target) {
                r = partition - 1;
            } else {
                l = partition + 1;
            }
        }
        return nums[target];
    }
}
