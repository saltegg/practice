package fzu.com.lc.pre200;

import java.util.ArrayList;
import java.util.List;

public class Solution89 {

    private static List<Integer> res = new ArrayList<>();
    private static boolean[] visited;

    private static boolean dfs(int cur, int n) {
        if (res.size() == (1 << n)) return true;
        for (int i = 0; i < n; i++) {
            int next = cur ^ (1 << i);
            if (visited[next]) continue;
            res.add(next);
            visited[next] = true;
            if (dfs(next, n)) return true;
            visited[next] = false;
            res.remove(res.size() - 1);
        }
        return false;
    }

    public static List<Integer> grayCode(int n) {
        visited = new boolean[1 << n];
        res.add(0);
        visited[0] = true;
        dfs(0, n);
        return res;
    }

    public static void main(String[] args) {
        grayCode(3);
    }
}
