package fzu.com.lc.pre200;

import java.util.HashMap;
import java.util.Map;

public class Solution166 {

    public static String fractionToDecimal(int numerator, int denominator) {

        long n = Math.abs(numerator);
        long d = Math.abs(denominator);
        StringBuilder ans = new StringBuilder();
        if ((numerator < 0 && denominator > 0)
                || (numerator > 0 && denominator < 0)) {
            ans.append("-");
        }
        ans.append(n / d);
        long rem = n % d;
        if (rem != 0) {
            Map<Long, Integer> map = new HashMap<>();
            ans.append(".");
            while (rem > 0) {
                if (map.containsKey(rem)) {
                    ans.insert(map.get(rem), "(");
                    ans.append(")");
                    break;
                }
                map.put(rem, ans.length());
                rem *= 10;
                long tmp = rem / d;
                rem = rem % d;
                ans.append(tmp);
            }
        }
        return ans.toString();
    }

}
