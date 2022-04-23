package fzu.com.bytedance;

public class Solution264 {

    public int nthUglyNumber(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        int idx2 = 1, idx3 = 1, idx5 = 1;
        for (int i = 2; i <= n; i++) {
            int a = dp[idx2] * 2;
            int b = dp[idx3] * 3;
            int c = dp[idx5] * 5;
            int min = Math.min(a, Math.min(b, c));
            if (min == a) idx2++;
            if (min == b) idx3++;
            if (min == c) idx5++;
            dp[i] = min;
        }
        return dp[n];
    }
}
