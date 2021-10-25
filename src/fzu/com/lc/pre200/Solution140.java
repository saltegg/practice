package fzu.com.lc.pre200;

import java.util.ArrayList;
import java.util.List;

public class Solution140 {

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    private void dfs(String s, List<String> wordDict, int begin) {
        if (begin == s.length()) {
            res.add(sb.deleteCharAt(sb.length() - 1).toString());
            sb.append(" ");
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (word.length() + begin <= s.length() &&
                    s.substring(begin, word.length() + begin).equals(word)) {
                sb.append(word).append(" ");
                dfs(s, wordDict, word.length() + begin);
                sb.delete(sb.length() - word.length() - 1, sb.length());
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        dfs(s, wordDict, 0);
        return res;
    }
}
