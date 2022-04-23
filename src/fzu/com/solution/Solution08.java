package fzu.com.solution;

public class Solution08 {

    public int myAtoi(String s) {

        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;  // 前导空格
        }
        int flag = 1;
        if (i == s.length()) return 0;
        if (s.charAt(i) == '-') {
            flag = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        int res = 0;
        for (; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
            int tmp = s.charAt(i) - '0';
            if (flag > 0 && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && tmp > 7))) {
                return Integer.MAX_VALUE;
            }
            if (flag < 0 && (flag * res < Integer.MIN_VALUE / 10 || (flag * res == Integer.MIN_VALUE / 10 && flag * tmp < -8))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + tmp;
        }
        return flag * res;
    }
}
