package fzu.com.codetop;

public class Solution70 {

    public int climbStairs(int n) {

        if (n < 3) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int t = b;
            b += a;
            a = t;
        }
        return b;
    }
}
