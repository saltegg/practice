package fzu.com.solution.bi;

public class Solution378 {

    /**
     * 思路非常简单：
     *
     * 找出二维矩阵中最小的数 left，最大的数 right，那么第 k 小的数必定在 leftleft ~ rightright 之间
     * mid=(left+right) / 2mid=(left+right)/2；在二维矩阵中寻找小于等于 midmid 的元素个数 countcount
     * 若这个 countcount 小于 kk，表明第 kk 小的数在右半部分且不包含 midmid，即 left=mid+1left=mid+1, right=rightright=right，又保证了第 kk 小的数在 leftleft ~ rightright 之间
     * 若这个 countcount 大于 kk，表明第 kk 小的数在左半部分且可能包含 midmid，即 left=leftleft=left, right=midright=mid，又保证了第 kk 小的数在 left~rightleft right 之间
     * 因为每次循环中都保证了第 kk 小的数在 leftleft ~ rightright 之间，当 left==rightleft==right 时，第 kk 小的数即被找出，等于 rightright
     *
     */

    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int l = matrix[0][0], r = matrix[row - 1][col - 1];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = fun(matrix, mid, row, col);
            if (cnt < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private int fun(int[][] matrix, int mid, int row, int col) {
        int cnt = 0;
        int i = row - 1, j = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                cnt += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return cnt;
    }
}
