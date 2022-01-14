package fzu.com.codetop;

public class Offer51 {

    int ans = 0;

    public int reversePairs(int[] nums) {
        sortArray(nums);
        return ans;
    }


    public int[] sortArray(int[] nums) {

        int l = 0, r = nums.length - 1;
        mergeSort(nums, l, r);
        return nums;
    }

    private void mergeSort(int[] nums, int l , int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
                ans += mid - i + 1;
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= r) {
            tmp[k++] = nums[j++];
        }
        for (i = 0; i < tmp.length; i++) {
            nums[i + l] = tmp[i];
        }
    }

}
