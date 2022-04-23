package fzu.com.solution;

public class Solution540 {

    public int singleNonDuplicate(int[] nums) {

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == nums[mid - 1]) {
                if ((mid - l) % 2 == 0) {
                    r = mid - 2;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if ((r - mid) % 2 == 0) {
                    l = mid + 2;
                } else {
                    r = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[r];
    }
}
