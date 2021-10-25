package fzu.com.lc.pointOffer;

public class Offer43 {
    public int countDigitOne(int n) {
        int count = 0;
        long i = 1L;
        while (n / i != 0) {
            int high = (int) (n / (i * 10));
            int cur = (int) ((n / i) % 10);
            int low = (int) (n % i);
            if (cur > 1) {
                count += (high + 1) * i;
            } else if (cur == 1) {
                count += high * i + low + 1;
            } else {
                count += high * i;
            }
            i *= 10;
        }
        return count;
    }
}
