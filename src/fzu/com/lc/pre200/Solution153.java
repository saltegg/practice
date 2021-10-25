package fzu.com.lc.pre200;

public class Solution153 {

    public int findMin(int[] nums) {

        int l = 0, r = nums.length - 1, min = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            } else if (nums[mid] >= nums[l]){
                min = Math.min(min, nums[l]);
                l = mid + 1;
            }
        }
        return min;
    }

    public int findMin1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
