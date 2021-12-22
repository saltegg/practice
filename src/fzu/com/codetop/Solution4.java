package fzu.com.codetop;

public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length, m = nums2.length;
        int left = (n + m + 1) / 2, right = (n + m + 2) / 2;
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) +
                getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {

        int len1 = e1 - s1 + 1, len2 = e2 - s2 + 1;

        if (len1 == 0 || len2 == 0) {
            return len1 == 0? nums2[s2 + k - 1] : nums1[s1 + k - 1];
        }

        if (k == 1) return Math.min(nums1[s1], nums2[s2]);

        int i = s1 + Math.min(len1, k / 2) - 1;
        int j = s2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, s1, e1, nums2, j + 1, e2, k - (j - s2 + 1));
        } else {
            return getKth(nums1, i + 1, e1, nums2, s2, e2, k - (i - s1 + 1));
        }

    }
}
