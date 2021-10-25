package fzu.com.lc.pre200;

import java.util.ArrayList;
import java.util.List;

public class Solution212 {

    private boolean[][] visited;
    private int m, n;

    private boolean dfs(char[][] board, String word, int cur, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) return false;
        if (visited[x][y]) return false;
        if (board[x][y] == word.charAt(cur)) {
            visited[x][y] = true;
            if (cur == word.length() - 1) return true;
            if (dfs(board, word, cur + 1, x + 1, y)) return true;
            if (dfs(board, word, cur + 1, x - 1, y)) return true;
            if (dfs(board, word, cur + 1, x, y + 1)) return true;
            if (dfs(board, word, cur + 1, x, y - 1)) return true;
            visited[x][y] = false;
        }
        return false;
    }

    public List<String> findWords(char[][] board, String[] words) {

        List<String> ans = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        //visited = new boolean[15][15];
        for (String word : words) {
            visited = new boolean[15][15];
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                if (flag) break;
                for (int j = 0; j < n; j++) {
                    flag = dfs(board, word, 0, i, j);
                    if (flag) {
                        ans.add(word);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
