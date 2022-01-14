package fzu.com.codetop;

public class Solution153 {


    public int findMin(int[] nums) {

        int l = 0, r = nums.length - 1;
        while (l  < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    public static int findMax(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[l]) {
                l = mid;
            } else if (nums[mid] < nums[l]){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(findMax(new int[]{7, 0, 6}));
    }
}
