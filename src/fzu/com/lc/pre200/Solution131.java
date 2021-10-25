package fzu.com.lc.pre200;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {

    List<List<String>> res = new ArrayList<>();
    List<String> subRes = new ArrayList<>();

    private void dfs(int begin, String s) {
        if (begin == s.length()) {
            res.add(new ArrayList<>(subRes));
            return;
        }
        for (int i = begin; i < s.length(); i++) {
            String subStr = s.substring(begin, i + 1);
            if (!isValid(subStr)) {
                continue;
            }
            subRes.add(subStr);
            dfs(i + 1, s);
            subRes.remove(subRes.size() - 1);
        }
    }

    private boolean isValid(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        dfs(0, s);
        return res;
    }
}
