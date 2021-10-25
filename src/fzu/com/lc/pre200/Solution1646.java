package fzu.com.lc.pre200;

public class Solution1646 {

    public static int getMaximumGenerated(int n) {

        if (n == 0 || n == 1) return n;
        int ans = 0;
        int[] num = new int[n + 1];
        num[0] = 0;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            num[i] = i % 2 == 0? num[i / 2] : num[(i + 1) / 2] + num[i / 2];
            ans = Math.max(ans, num[i]);
        }
        return ans;
    }

}
