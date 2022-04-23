package fzu.com.codetop;

import java.util.List;

/**
 * @Author: linxiaohui
 * @Date: 2022/01/23 14:34
 * @Description:
 */
public class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len) {
                    dp[i] = word.equals(s.substring(i - len, i)) &&
                            dp[i - len];
                }
                if (dp[i]) break;
            }
        }
        return dp[s.length()];
    }
}
