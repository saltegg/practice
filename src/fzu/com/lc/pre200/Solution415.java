package fzu.com.lc.pre200;

public class Solution415 {

    public static String addStrings(String num1, String num2) {

        int addition = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int tmp = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + addition;
            int cur = tmp % 10;
            addition = tmp / 10;
            res.append(cur);
            i--;
            j--;
        }
        if (i >= 0) {
            while (i >= 0) {
                int tmp = num1.charAt(i) - '0' + addition;
                int cur = tmp % 10;
                addition = tmp / 10;
                res.append(cur);
                i--;
            }
        }
        if (j >= 0) {
            while (j >= 0) {
                int tmp = num2.charAt(j) - '0' + addition;
                int cur = tmp % 10;
                addition = tmp / 10;
                res.append(cur);
                j--;
            }
        }
        if (addition > 0) res.append('1');
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        addStrings("0", "11");
    }
}
