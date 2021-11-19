package fzu.com.lc.pre200;

/**
 * @Author: linxiaohui
 * @Date: 2021/11/12 10:29
 * @Description:
 */
public class Solution875 {

    public static int leftBound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    public static int rightBound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int left = 1, right = 1000000000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (speed(piles, mid) > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static int speed(int[] piles, int x) {
        int t = 0;
        for (int pile : piles) {
            t += pile / x;
            if (pile % x > 0) t++;
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(rightBound(new int[]{1,2,3,3,3,5,5,7}, 5));
    }
}
