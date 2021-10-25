package fzu.com.lc.pre200;

public class Solution600 {

    public static int findIntegers(int n) {

        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 3; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        String num = getBi(n);
        int res = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                continue;
            }
            res += dp[num.length() - i - 1];
            if (i > 0 && num.charAt(i - 1) == '1') {
                return res;
            }
        }
        return res + 1;
    }

    private static String getBi(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n & 1);
            n >>= 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        findIntegers(5);
    }
}
