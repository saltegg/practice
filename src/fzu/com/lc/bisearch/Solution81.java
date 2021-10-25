package fzu.com.lc.bisearch;

public class Solution81 {

    public static boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;
            if (nums[r] == nums[mid]) {
                r--;   // 去重 [1,0,1,1,1]  [1,1,1,0,1]
            } else if (nums[mid] < nums[r]) {
                if (nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            } else {
                if (target >= nums[l] && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] t = {1, 1, 3, 1};
        System.out.println(search(t, 3));
    }
}
