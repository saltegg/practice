package fzu.com.lc.pointOffer;

import java.util.ArrayList;
import java.util.List;

public class Offer49 {
    public int nthUglyNumber(int n) {  // 超时
        if (n <= 5) return n;
        int i;
        List<Integer> list = new ArrayList<>();
        for (i = 1; i < 6; i++) list.add(i);
        while (!(list.size() == n)) {
            for (int j = list.size() - 1; j >= 1; j--) {
                int tmp = list.get(j);
                if (i % tmp == 0 && list.contains(i / tmp)) {
                    list.add(i);
                    break;
                }
            }
            i++;
        }
        return list.get(list.size() - 1);
    }

    public int nthUglyNumber1(int n) {
        int[] dp = new int[n];
        int id2 = 0, id3 = 0, id5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[id2] * 2, Math.min(dp[id3] * 3, dp[id5] * 5));
            if (dp[i] == dp[id2] * 2) id2++;
            if (dp[i] == dp[id3] * 3) id3++;
            if (dp[i] == dp[id5] * 5) id5++;
        }
        return dp[n - 1];
    }

}
