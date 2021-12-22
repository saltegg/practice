package fzu.com.codetop;

public class Solution8 {

    public int myAtoi(String s) {

        int i = 0, ans = 0, flag = 1;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) return 0;
        if (s.charAt(i) == '-') {
            flag = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        for (int j = i; j < s.length() && Character.isDigit(s.charAt(j)); j++) {
            int p = s.charAt(j) - '0';
            if (flag == 1 && (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && p > 7))) return Integer.MAX_VALUE;
            if (flag == -1 && (flag * ans < Integer.MIN_VALUE / 10 || (flag * ans == Integer.MIN_VALUE / 10 &&
                    p * flag < -8))) return Integer.MIN_VALUE;
            ans = ans * 10 + p;
        }
        return flag * ans;
    }
}
