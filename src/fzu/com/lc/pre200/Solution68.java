package fzu.com.lc.pre200;

public class Solution68 {
    public int mySqrt(int x) {

        if (x == 0) return 0;
        int l = 1, r = x, memo = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int sqrt = x / mid;
            if (mid == sqrt) {
                return mid;
            } else if (mid > sqrt) {
                r = mid - 1;
            } else {
                memo = mid;
                l = mid + 1;
            }
        }
        return memo;
    }
}
