package fzu.com.codetop;

public class Solution151 {

    public String reverseWords(String s) {

        StringBuilder res = new StringBuilder();
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (c == ' ') {
                if (r == l) {
                    l++;
                } else {
                    res.insert(0, s.substring(l, r) + " ");
                    l = r;
                }
            } else {
                if (s.charAt(l) == ' ') l++;
            }
            r++;
        }
        res.insert(0, s.substring(l, r));
        return res.toString();
    }
}
