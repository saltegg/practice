package fzu.com.lc.pointOffer;

public class Offer44 {
    public static int findNthDigit(int n) {
        int bit = 0, itr = 1, init = 10;
        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            if (i == init) {
                itr++;
                init *= 10;
            }
            if (bit + itr >= n + 1) {
                int tmp = bit + itr;
                int curI = i;
                while (curI > 0) {
                    if (tmp == n + 1) return curI % 10;
                    tmp--;
                    curI /= 10;
                }
            }
            bit += itr;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(4325  % 1000);
    }
}
