package fzu.com.lc.pre200;

public class Solution36 {

    public boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int index = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[index][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[index][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
