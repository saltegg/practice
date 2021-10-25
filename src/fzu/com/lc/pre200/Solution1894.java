package fzu.com.lc.pre200;

public class Solution1894 {

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        int i = 0;
        for (int v : chalk) {
            sum += v;
        }
        k %= sum;
        while (true) {
            if (k - chalk[i] >= 0) {
                k -= chalk[i];
                i = ++i % chalk.length;
            } else {
                break;
            }
        }
        return i;
    }
}
