package fzu.com.codetop;

public class Solution443 {

    public int compress(char[] chars) {

        int k = 0, cnt = 1;
        char cur = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                 cnt++;
            } else {
                chars[k++] = cur;
                if (cnt > 1) {
                    String d = String.valueOf(cnt);
                    for (char t : d.toCharArray()) {
                        chars[k++] = t;
                    }
                }
                cur = chars[i];
                cnt = 1;
            }
        }
        chars[k++] = cur;
        if (cnt > 1) {
            String d = String.valueOf(cnt);
            for (char t : d.toCharArray()) {
                chars[k++] = t;
            }
        }
        return k;
    }
}
