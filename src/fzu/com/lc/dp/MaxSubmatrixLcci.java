package fzu.com.lc.dp;
 
//给定一个正整数、负整数和 0 组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。 
//
// 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满
//足条件的子矩阵，返回任意一个均可。 
//
// 注意：本题相对书上原题稍作改动 
//
// 示例： 
//
// 输入：
//[
//   [-1,0],
//   [0,-1]
//]
//输出：[0,1,0,1]
//解释：输入中标粗的元素即为输出所表示的矩阵 
//
// 
//
// 说明： 
//
// 
// 1 <= matrix.length, matrix[0].length <= 200 
// 
// Related Topics 动态规划 
// 👍 45 👎 0

import java.util.List;

public class MaxSubmatrixLcci{
    public static void main(String[] args) {
	    Solution solution = new MaxSubmatrixLcci().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getMaxMatrix(int[][] matrix) {

        int[] ans = new int[4];
        int n = matrix.length, m = matrix[0].length, maxValue = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < n; r1++) {
            int[] dp = new int[m];
            for (int r2 = r1; r2 < n; r2++) {
                int sum = 0;
                int c1 = 0;
                for (int c2 = 0; c2 < m; c2++) {
                    dp[c2] += matrix[r2][c2];
                    if (sum > 0) {
                        sum += dp[c2];
                    } else {
                        sum = dp[c2];
                        c1 = c2;
                    }
                    if (sum > maxValue) {
                        maxValue = sum;
                        ans[0] = r1;
                        ans[1] = c1;
                        ans[2] = r2;
                        ans[3] = c2;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}