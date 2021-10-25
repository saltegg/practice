package fzu.com.lc.traceback;

import java.util.ArrayList;
import java.util.List;

// N 皇后问题
public class Solution51 {

    private boolean checkValid(int[] queenPos, int cur) {  // 检擦对角线是否合法
        for (int i = 0; i < cur; i++) {
            if (Math.abs(queenPos[cur] - queenPos[i]) == Math.abs(cur - i)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int n, int cur, List<List<String>> res, int[] queenPos, boolean[] isVisited) {
        if (cur == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == queenPos[i]) sb.append('Q');
                    else sb.append('.');
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                queenPos[cur] = i;
                if (checkValid(queenPos, cur)) {
                    isVisited[i] = true;
                    dfs(n, cur + 1, res, queenPos, isVisited);
                    isVisited[i] = false;
                }
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queenPos = new int[n + 1];
        boolean[] isVisited = new boolean[n + 1];
        dfs(n, 0, res, queenPos, isVisited);
        return res;
    }
}
