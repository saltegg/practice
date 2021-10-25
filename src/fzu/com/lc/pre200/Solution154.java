package fzu.com.lc.pre200;

public class Solution154 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == nums[r]) {
                r--;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    public static int findMin1(int[] nums) {

        int l = 0, r = nums.length - 1;
        while (l < r) {
            //对于任何一个旋转数组，除非没有旋转，否则最左边必然大于等于最右边
            if(nums[l] < nums[r]) return nums[l];
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[l]) {
                l = mid + 1;
            } else {
                l++;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        findMin1(new int[]{1,3,5});
    }
}
