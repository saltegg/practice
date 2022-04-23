package fzu.com.codetop;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution378 {

    public int kthSmallest(int[][] matrix, int k) {   // 多路归并

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] cur = pq.poll();
            if (cur[2] != n - 1) {
                pq.add(new int[]{matrix[cur[1]][cur[2] + 1], cur[1], cur[2] + 1});
            }
        }
        return pq.poll()[0];
    }

    public int kthSmallest1(int[][] matrix, int k) {  // 二分法
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

}
