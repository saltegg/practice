package fzu.com.lc.traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    private static void traceBack(int n, int cur, int left, int right, StringBuilder sb, List<String> lists) {

        if (cur == 2 * n) {
            lists.add(sb.toString());
        } else {
            for (int i = 0; i < 2; i++) {
                if (i == 0 && left > 0) {
                    left--;
                    sb.append("(");
                    traceBack(n, cur + 1, left, right, sb, lists);
                    left++;
                    sb.deleteCharAt(sb.length() - 1);
                } else if (i == 1 && right > 0 && right > left) {
                    right--;
                    sb.append(")");
                    traceBack(n, cur + 1, left, right, sb, lists);
                    right++;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

    }

    public static List<String> generateParenthesis(int n) {
        List<String> lists = new ArrayList<>();
        traceBack(n, 0, n, n, new StringBuilder(), lists);
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
