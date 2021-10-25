package fzu.com.lc.pointOffer;

public class Offer51 {

    private int ans;
    private int[] temp;

    private void mergeSort(int[] nums, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            temp[k] = nums[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) nums[k] = temp[j++];
            else if (j > hi) nums[k] = temp[i++];
            else if (temp[i] <= temp[j]) nums[k] = temp[i++];
            else {
                ans += mid - i + 1;
                nums[k] = temp[j++];
            }
        }
    }

    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }

}
