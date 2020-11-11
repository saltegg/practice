package fzu.com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution20 {

    public static boolean isValid(String s) {
        List<Character> cs = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                cs.add(c);
            } else if (cs.size() > 0) {
                char lastC = cs.get(cs.size() - 1);
                if ((lastC =='(' && c == ')') || (lastC =='[' && c == ']') || (lastC =='{' && c == '}')) {
                    cs.remove(cs.size() - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return cs.size() <= 0;
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
}
