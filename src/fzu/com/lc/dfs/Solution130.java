package fzu.com.lc.dfs;

public class Solution130 {

    private int[] dir = {-1, 0, 1, 0, -1};

    private void dfs(char[][] board, int n, int m, int x , int y, char tag) {
        if (x < 0 || x >= n || y < 0 || y>= m || board[x][y] == 'X' || board[x][y] == '2') return;
        board[x][y] = tag;
        for (int i = 0; i < 4; i++) {
            int r = x + dir[i];
            int c = y + dir[i + 1];
            dfs(board, n, m, r, c, tag);
        }
    }

    public void solve(char[][] board) {

        if (null == board || board.length == 0) return;
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, n, m, i, 0, '2');
            dfs(board, n, m, i, m - 1, '2');
        }
        for (int i = 0; i < m; i++) {
            dfs(board, n, m, 0, i, '2');
            dfs(board, n, m, n - 1, i, '2');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '2') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
