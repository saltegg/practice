package fzu.com.codetop;

public class Solution69 {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1, r = x / 2 + 1, e = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt < mid) {
                r = mid - 1;
            } else {
                e = mid;
                l = mid + 1;
            }
        }
        return e;
    }
}
