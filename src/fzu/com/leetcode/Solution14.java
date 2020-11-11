package fzu.com.leetcode;

public class Solution14 {
    public static String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        StringBuilder stringBuilder = new StringBuilder();
        if (strs.length > 0) {
            for (String str : strs) minLength = Math.min(str.length(), minLength);
            for (int i = 0; i < minLength; i++) {
                for (int j = 0; j < strs.length - 1; j++) {
                    if (strs[j].charAt(i) != strs[j + 1].charAt(i)) return stringBuilder.toString();
                }
                stringBuilder.append(strs[0].charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
