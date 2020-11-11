package fzu.com.leetcode;

public class Solution7 {
    public static int reverse(int x) {
        int reverseX = 0;
        while (x != 0){
            int p = x % 10;
            if(reverseX > Integer.MAX_VALUE / 10 || (reverseX == Integer.MAX_VALUE / 10 && p > 7)) return 0;
            if(reverseX < Integer.MIN_VALUE / 10 || (reverseX == Integer.MIN_VALUE / 10 && p < -8)) return 0;
            reverseX = reverseX * 10 + p;
            x /= 10;
        }
        return  reverseX;
    }
}
