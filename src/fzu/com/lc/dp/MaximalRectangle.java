package fzu.com.lc.dp;
 
//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 678 👎 0

public class MaximalRectangle{
    public static void main(String[] args) {

        char[][] t = {
                {'1','0','1','1','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}
        };

        Solution solution = new MaximalRectangle().new Solution();
        System.out.println(solution.maximalRectangle(t));
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Node {
        int x, y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int maximalRectangle(char[][] matrix) {  // 85

        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length, max = 0;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                int minWidth = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    int height = i - k + 1;
                    minWidth = Math.min(minWidth, dp[k][j]);
                    max = Math.max(max, minWidth * height);
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}