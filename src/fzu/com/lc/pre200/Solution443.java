package fzu.com.lc.pre200;

public class Solution443 {


    public int compress(char[] chars) {
        int count = 1, k = 0;
        char tmp = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == tmp) {
                count++;
            } else  {
                chars[k++] = tmp;
                if (count > 1) {
                    String digit = String.valueOf(count);
                    for (char c : digit.toCharArray()) {
                        chars[k++] = c;
                    }
                }
                tmp = chars[i];
                count = 1;
            }
        }
        chars[k++] = tmp;
        if (count > 1) {
            String digit = String.valueOf(count);
            for (char c : digit.toCharArray()) {
                chars[k++] = c;
            }
        }
        return k;
    }
}
