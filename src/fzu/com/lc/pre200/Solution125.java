package fzu.com.lc.pre200;

public class Solution125 {

    public boolean isPalindrome(String s) {

        int l = s.length();
        StringBuilder sb = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(c);
            }
        }
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }
}
