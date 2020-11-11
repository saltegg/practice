package fzu.com.leetcode;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int len = nums1.length + nums2.length;
        int[] nums = new int[len];
        while(i < nums1.length && j < nums2.length){
            if (nums1[i] <= nums2[j])
                nums[k++] = nums1[i++];
            else
                nums[k++] = nums2[j++];
        }

        while(i < nums1.length){
            nums[k++] = nums1[i++];
        }

        while(j < nums2.length){
            nums[k++] = nums2[j++];
        }

        if (len % 2 == 0) {    //偶数个时
            return (nums[len / 2] + nums[len / 2 - 1]) * 1.0 / 2;
        } else {              //奇数个时
            return nums[len / 2];
        }
    }
}
