package fzu.com.codetop;

public class Solution34 {

    public int[] searchRange(int[] nums, int target) {

        int[] res = {-1, -1};
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l == nums.length || nums[l] != target) return res;
        res[0] = l;
        r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        res[1] = l - 1;
        return res;
    }
}
