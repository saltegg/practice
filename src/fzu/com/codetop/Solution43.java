package fzu.com.codetop;

public class Solution43 {


    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        StringBuilder res = new StringBuilder("0");
        int cnt = 0; // 补0
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder t = multi(num1, num2.charAt(i));
            for (int j = 0; j < cnt; j++) t.append(0);
            cnt++;
            res = sum(res, t);
        }
        return res.toString();
    }

    private static StringBuilder multi(String a, char c) {
        if (c == '0') return new StringBuilder("0");
        int len = a.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (len >= 0) {
            int t = (a.charAt(len) - '0') * (c - '0') + add;
            add = t / 10;
            t %= 10;
            sb.append(t);
            len--;
        }
        if (add > 0) sb.append(add);
        return sb.reverse();
    }

    private static StringBuilder sum(StringBuilder a, StringBuilder b) {

        int len1 = a.length() - 1, len2 = b.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (len1 >= 0 && len2 >= 0) {
            int t = a.charAt(len1) - '0' + b.charAt(len2) - '0' + add;
            add = t / 10;
            t %= 10;
            sb.append(t);
            len1--;
            len2--;
        }
        if (len1 >= 0) {
            while (len1 >= 0) {
                int t = a.charAt(len1) - '0' + add;
                add = t / 10;
                t %= 10;
                sb.append(t);
                len1--;
            }
        }
        if (len2 >= 0) {
            while (len2 >= 0) {
                int t = b.charAt(len2) - '0' + add;
                add = t / 10;
                t %= 10;
                sb.append(t);
                len2--;
            }
        }
        if (add > 0) sb.append(add);
        return sb.reverse();
    }

    public static void main(String[] args) {
        //System.out.println(sum("456", "77"));
        //System.out.println(multi("199999", '9'));
        System.out.println(multiply("0", "8688"));
    }
}
