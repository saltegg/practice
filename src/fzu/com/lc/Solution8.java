package fzu.com.lc;

public class Solution8 {

    public static int myAtoi(String str) {
        if (str != null && str.length() != 0) {
            int flag = 1, ans = 0;    //-1代表是负数， 1代表是正数
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '+' || c == '-') {
                    if(ans != 0) break;
                    flag = c == '+'? 1 : -1;
                    if (i < str.length() - 1 &&
                            (str.charAt(i + 1) == '+' || str.charAt(i + 1) == '-' || str.charAt(i + 1) == ' '))
                        break;
                } else if (c >= '0' && c <='9') {
                    int p = c - '0';
                    if (flag == 1 && (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && p > 7)))
                        return Integer.MAX_VALUE;
                    if (flag == -1 &&
                            (flag * ans < Integer.MIN_VALUE / 10 ||
                                    (flag * ans == Integer.MIN_VALUE / 10 && p * flag < -8)))
                        return Integer.MIN_VALUE;
                    ans = ans * 10 + p;
                    if (i < str.length() - 1 && (str.charAt(i + 1) < '0' ||  str.charAt(i + 1) > '9'))
                        break;
                } else if (c != ' '){
                    break;
                }
            }
            return ans * flag;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-   234"));
    }
}
