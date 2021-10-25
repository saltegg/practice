package fzu.com.lc.bisearch;

public class Solution154 {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE, l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            min = Math.min(nums[mid], min);
            if (nums[mid] == nums[r]) {
                r--;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return min;
    }
}
