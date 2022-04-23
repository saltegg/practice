package fzu.com.solution.bi;

public class Solution154 {

    public static int findMin(int[] nums) {

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[r] == nums[mid]) {
                r--;
                continue;
            }
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

}
