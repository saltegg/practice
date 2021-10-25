package fzu.com.lc.towpoint;


public class Solution633 {

    public static boolean judgeSquareSum(int c) {

        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int t = i * i + j * j;
            if (t == c) return true;
            else if (t < c) i++;
            else j--;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
