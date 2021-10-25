package fzu.com.lc.pre200;

public class Solution91 {

    public int numDecodings(String s) {

        /**
         * dp[i]表示前i个字符有几种解码方式
         * 对于第i个字符，首先要知道他是否为0
         * 如果s[i]为0，它就只能和s[i-1]抱团(抱团结果要有效),那么解码方式就是dp[i-2]
         * 如果s[i]不为0,它就可以自成一派，解码方式就为dp[i - 1]
         * 或者跟s[i-1]抱团(抱团结果要有效)，解码方式为dp[i - 2]
         * 总的解码方式为 dp[i - 1] + dp[i - 2]
         *
         * 注意:0,前导0,连续0,26等边界
         */

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = s.charAt(i - 1) == '0'? 0 : dp[i - 1];
            if (i > 1) {
                int d = Integer.parseInt(s.substring(i - 2, i));
                if (s.charAt(i - 2) != '0' && d > 0 && d <= 26) dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
