package fzu.com.lc.traceback;

public class Solution79 {

    private static boolean dfs(char[][] board, String word, int x, int y, int cur, boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (visited[x][y]) return false;
        if (board[x][y] == word.charAt(cur)) {
            visited[x][y] = true;
            if (cur == word.length() - 1) return true;
            if (dfs(board, word, x - 1, y, cur + 1, visited)) return true;
            if (dfs(board, word, x, y + 1, cur + 1, visited)) return true;
            if (dfs(board, word, x, y - 1, cur + 1, visited)) return true;
            if (dfs(board, word, x + 1, y, cur + 1, visited)) return true;
            visited[x][y] = false;
        }
        return false;
    }

    public static boolean exist(char[][] board, String word) {
        boolean res = false;
        boolean[][] visited = new boolean[201][201];
        for (int i = 0; i < board.length; i++) {
            if (res) break;
            for (int j = 0; j < board[0].length; j++) {
                res = dfs(board, word, i, j, 0, visited);
                if (res) break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";

        System.out.println(exist(board, word));
    }
}
