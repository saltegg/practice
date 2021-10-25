package fzu.com.lc.bisearch;

public class Solution153 {

    public static int findMin(int[] nums) {

        int min = Integer.MAX_VALUE, l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            min = Math.min(nums[mid], min);
            if (nums[mid] < nums[r]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] t = {3, 1, 2};
        System.out.println(findMin(t));
    }
}
