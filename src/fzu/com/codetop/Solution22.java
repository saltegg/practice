package fzu.com.codetop;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    private final List<String> res = new ArrayList<>();

    private void dfs(int n, int cur, int a, int b, StringBuilder sb) {

        if (cur == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (a > 0) {
            sb.append("(");
            dfs(n, cur + 1, a - 1, b, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (b > 0 && b - 1 >= a) {
            sb.append(")");
            dfs(n, cur + 1, a, b - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, n, n, new StringBuilder());
        return res;
    }
}
