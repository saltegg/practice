package fzu.com.lc.pre200;

public class Solution482 {

    public String licenseKeyFormatting(String s, int k) {

        int cnt = 0;
        StringBuilder s1 = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '-') {
                s1.append(c);
            }
        }
        if (s1.length() == 0) return "";
        StringBuilder s2 = new StringBuilder();
        int i = s1.length() - 1;
        while (i >= 0) {
            s2.append(Character.toUpperCase(s1.charAt(i)));
            cnt++;
            if (cnt / k == 1) {
                s2.append('-');
                cnt = 0;
            }
            i--;
        }
        return s1.length() % k == 0? s2.reverse().toString().substring(1, s2.length()) : s2.reverse().toString();
    }
}
