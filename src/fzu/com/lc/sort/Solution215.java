package fzu.com.lc.sort;

public class Solution215 {

    public int getPartition(int[] nums, int left, int right) {
        int tmp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= tmp) right--;
            if (left < right) nums[left] = nums[right];
            while (left < right && nums[left] < tmp) left++;
            if (left < right) nums[right] = nums[left];
        }
        nums[left] = tmp;
        return left;
    }

    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1, target = nums.length - k;
        while (l < r) {
            int mid = getPartition(nums, l, r);
            if (mid == target) {
                return nums[target];
            } else if (target > mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] t = {3,2,3,1,2,4,5,5,6};
        //System.out.println(findKthLargest(t, 4));
    }
}
