package fzu.com.leetcode;

public class Solution9 {
    public boolean isPalindrome(int x) {
        boolean result = true;
        if (x == 0) {
            result = true;
        } else if (x < 0) {
            result = false;
        } else {
            int k = 0;
            int[] a = new int[20];
            while (x > 0) {
                a[k++] = x % 10;
                x /= 10;
            }
            for (int i = 0, j = k - 1; i < j; i++, j--) {
                if(a[i] != a[j]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
