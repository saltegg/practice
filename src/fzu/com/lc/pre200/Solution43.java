package fzu.com.lc.pre200;

public class Solution43 {

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int addition = 0; // 进位
        String res = "0"; // 输出结果
        for (int i = num2.length() - 1; i >= 0 ; i--) {
            char c = num2.charAt(i);
            StringBuilder product = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {
                int tmp = (num1.charAt(j) - '0') * (c - '0') + addition;
                int cur = tmp % 10;
                addition = tmp / 10;
                product.append(cur);
            }
            if (addition > 0) {
                product.append(addition);
                addition = 0;
            }
            product.reverse();
            for (int j = 1; j < num2.length() - i; j++) {
                product.append('0'); // 末尾补0
            }
            res = addStrings(res, product.toString());
        }
        return res;
    }

    private static String addStrings(String num1, String num2) {
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
        multiply("9", "9");
    }
}
