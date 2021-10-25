package fzu.com.lc;

import java.util.HashMap;
import java.util.Map;

public class Solution13 {

    public static int romanToInt(String s) {
        String[] ss = {"I", "II", "III", "IV", "V", "VI","VII", "VIII",
                "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] aa = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder stringBuilder = new StringBuilder();
        String m = "";
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < ss.length; i++) map.put(ss[i], aa[i]);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                m = stringBuilder.toString();
                stringBuilder.append(s.charAt(j));
                if(!map.containsKey(stringBuilder.toString())) {
                    i = j - 1;
                    break;
                }
                if (s.length() - 1 == j) {
                    i = s.length() - 1;
                    m = stringBuilder.toString();
                    break;
                }
            }
            ans += map.get(m);
            stringBuilder.delete(0, stringBuilder.length());
        }
        return ans;
    }
}
