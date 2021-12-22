package fzu.com.codetop;

public class Solution415 {

    public String addStrings(String num1, String num2) {

        int len1 = num1.length() - 1, len2 = num2.length() - 1;
        int addition = 0;
        StringBuilder res = new StringBuilder();
        String num = len1 > len2? num1 : num2;
        while (len1 >= 0 && len2 >= 0) {
            int sum = num1.charAt(len1) - '0' + num2.charAt(len2) - '0' + addition;
            addition = sum >= 10? 1 : 0;
            res.append(sum % 10);
            len1--;
            len2--;
        }
        int len = len1 >= 0? len1 : len2;
        while (len >= 0) {
            int sum = num.charAt(len) - '0' + addition;
            addition = sum >= 10? 1 : 0;
            res.append(sum % 10);
            len--;
        }
        if (addition > 0) res.append(addition);
        return res.reverse().toString();
    }
}
