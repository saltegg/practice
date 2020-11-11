package fzu.com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class solution17 {
    public static List<String> letterCombinations(String digits) {

        String[] strs = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        if (!digits.equals("")) {
            traceBack(list, 0, strs, new StringBuilder(), digits);
        }
        return list;
    }

    private static void traceBack(List<String> list, int cur, String[] strs, StringBuilder sb, String digits) {
        if (cur == digits.length()) {
            list.add(sb.toString());
        } else {
            String s = strs[digits.charAt(cur) - '0' - 2];
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                traceBack(list, cur + 1, strs, sb, digits);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(letterCombinations(s).toString());
    }
}
