package fzu.com.codetop;

public class Solution912 {

    private int p(int[] nums, int l, int r) {

        int tmp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= tmp) r--;
            if (l < r) nums[l] = nums[r];
            while (l < r && nums[l] < tmp) l++;
            if (l < r) nums[r] = nums[l];
        }
        nums[l] = tmp;
        return l;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int partition = p(nums, l, r);
            quickSort(nums, l, partition - 1);
            quickSort(nums, partition + 1, r);
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}
