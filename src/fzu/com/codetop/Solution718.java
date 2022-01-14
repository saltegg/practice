package fzu.com.codetop;

public class Solution718 {

    public int findLength(int[] nums1, int[] nums2) {

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res;
    }
}
