package fzu.com.lc.bisearch;

public class Solution35 {

    /**
     * 二分搜索
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if(target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1  ;
            } else {
                return mid;
            }
        }
        return low;
    }
}
