package fzu.com.lc.pre200;

import java.util.*;

public class Competition262 {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        List<Integer> ans = new ArrayList<>();
        int[] a = new int[101];
        int[] b = new int[101];
        int[] c = new int[101];
        for (int num : nums1) {
            a[num] = 1;
        }
        for (int num : nums2) {
            b[num] = 1;
        }
        for (int num : nums3) {
            c[num] = 1;
        }
        for (int i = 1; i <= 100; i++) {
            if (a[i] + b[i] + c[i] >= 2) {
                ans.add(i);
            }
        }
        return ans;
    }

    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[n * m];
        int k = 0, cnt = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                arr[k++] = ints[j];
            }
        }
        Arrays.sort(arr);
        int mid = arr[k / 2];
        for (int i = 0; i < k; i++) {
            int t = Math.abs(mid - arr[i]);
            if (t % x != 0) return -1;
            else cnt += t / x;
        }
        return cnt;
    }
}
