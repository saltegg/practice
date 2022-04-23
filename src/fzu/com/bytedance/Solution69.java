package fzu.com.bytedance;

public class Solution69 {

    public int mySqrt(int x) {

        if (x <= 1) return x;
        int l = 1, r = x / 2 + 1, e= l;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt > mid) {
                e = l;
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return e;
    }
}
