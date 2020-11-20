package fzu.com.leetcode;


/*面试题 10.01. 合并排序的数组**/

public class Solution10_01 {

    /*
    以下解法时间要1s，看了题解其中0s的一种解法思路大致如下：
    分别从m-1, n-1, n+m-1开始，将AB进行从大到小进行归并，大的放A数组末尾，（这里的从大到小排序是反过来看的）
    这样就可以不用移动数组元素了
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int k = 0;
        for (int i = 0; i < m + k && k < n; i++) {
            if(A[i] > B[k]) {
                for (int j = m + k - 1; j >= i; j--) {
                    A[j + 1] = A[j];  // if (m + k - i >= 0) System.arraycopy(A, i, A, i + 1, m + k - i);
                }
                A[i] = B[k++];
            }
        }
        while (k < n) {
            A[m + k] = B[k++];
        }
    }

}
