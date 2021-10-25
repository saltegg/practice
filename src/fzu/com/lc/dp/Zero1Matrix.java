package fzu.com.lc.dp;
 
//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
//
//输出：
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
// 
//
// 示例 2： 
//
// 
//输入：
//[[0,0,0],
// [0,1,0],
// [1,1,1]]
//
//输出：
//[[0,0,0],
// [0,1,0],
// [1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 358 👎 0

import java.util.LinkedList;
import java.util.Queue;

public class Zero1Matrix{
    public static void main(String[] args) {
	    int[][] t = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        //System.out.println(2 >> 1);
        Solution solution = new Zero1Matrix().new Solution();
        solution.updateMatrix(t);
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    private int[][] updateM(int[][] matrix) {

        Queue<int[]> queue = new LinkedList<>();
        int n = matrix.length, m = matrix[0].length;
        int[] dir = {-1, 0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            for (int k = 0; k < 4; k++) {
                int newX = x + dir[k];
                int newY = y + dir[k + 1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        return matrix;
    }

    public int[][] updateMatrix(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE >> 1;
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                }
            }
        }

        for (int i = n -1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    if (j < m -1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                    if (i < n -1) {
                        dp[i][j] = Math.min(dp[i][j],dp[i + 1][j] + 1);
                    }
                }
            }
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}