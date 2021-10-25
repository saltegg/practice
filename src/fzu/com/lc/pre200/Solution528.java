package fzu.com.lc.pre200;

import java.util.Random;

public class Solution528 {

    private int[] preSum;
    private int sum;

    public Solution528(int[] w) {
        preSum = new int[w.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
        sum = preSum[preSum.length - 1];
    }

    public int pickIndex() {
        int r = new Random().nextInt(sum);
        return biSearch(r);
    }

    private int biSearch(int target) {
        int l = 0, r = preSum.length - 1, memo = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (preSum[mid] == target) {
                return mid;
            } else if (preSum[mid] < target) {
                memo = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return memo;
    }
}
