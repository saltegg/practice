package fzu.com.lc;

public class Solution12 {

    public static String intToRoman(int num) {

        String[] ss = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        int[] aa = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            for (int i = ss.length - 1; i >= 0; i--) {
                if (num >= aa[i]) {
                    num -= aa[i];
                    stringBuilder.append(ss[i]);
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(6));
    }

}

