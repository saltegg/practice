package fzu.com.solution;

public class Solution09 {

    public boolean isPalindrome(int x) {

        //boolean res = true;
        if (x == 0) {
            return true;
        } else if (x < 0) {
            return false;
        } else {
            int k = 0;
            int[] a = new int[20];
            while (x > 0) {
                a[k++] = x % 10;
                x /= 10;
            }
            for (int i = 0, j = k - 1; i < j; i++, j--) {
                if (a[i] != a[j]) return false;
            }
        }
        return true;
    }
}
