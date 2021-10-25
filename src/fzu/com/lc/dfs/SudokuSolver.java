package fzu.com.lc.dfs;
 
//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 716 👎 0

public class SudokuSolver{
    public static void main(String[] args) {
	    Solution solution = new SudokuSolver().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Node {
        int  x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean dfs(boolean[][] columnFlag, boolean[][] rowFlag, boolean[][] blockFlag,
                     char[][] board, int k, int cur, Node[] nodes) {
        if (cur == k) {
            return true;
        }
        int x = nodes[cur].x;
        int y = nodes[cur].y;
        int block = x / 3 * 3 + y / 3;
        for (int i = 1; i <= 9; i++) {
            if (!columnFlag[y][i] && !rowFlag[x][i] && !blockFlag[block][i]) {
                board[x][y] = (char)('0' + i);
                columnFlag[y][i] = true;
                rowFlag[x][i] = true;
                blockFlag[block][i] = true;
                if (dfs(columnFlag, rowFlag, blockFlag, board, k, cur + 1, nodes)) return true;
                columnFlag[y][i] = false;
                rowFlag[x][i] = false;
                blockFlag[block][i] = false;
                board[x][y] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {

        int k = 0;
        boolean[][] columnFlag = new boolean[9][10];
        boolean[][] rowFlag = new boolean[9][10];
        boolean[][] blockFlag = new boolean[9][10];
        Node[] nodes = new Node[81];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    nodes[k++] = new Node(i, j);
                } else {
                    columnFlag[j][board[i][j] - '0'] = true;
                    rowFlag[i][board[i][j] - '0'] = true;
                    blockFlag[i / 3 * 3 + j / 3][board[i][j] - '0'] = true;
                }
            }
        }
        dfs(columnFlag, rowFlag, blockFlag, board, k, 0, nodes);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}