package fzu.com.leetcode;


/*面试题 10.01. 合并排序的数组**/

public class Solution10_01 {

    public void merge(int[] A, int m, int[] B, int n) {
        int k = 0;
        for (int i = 0; i < m + k && k < n; i++) {
            if(A[i] > B[k]) {
                for (int j = m + k - 1; j >= i; j--) {
                    A[j + 1] = A[j];
                }
                A[i] = B[k++];
            }
        }
        while (k < n) {
            A[m + k] = B[k++];
        }
    }

}
