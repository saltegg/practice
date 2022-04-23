package fzu.com.codetop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: linxiaohui
 * @Date: 2022/01/23 14:53
 * @Description:
 */
public class Solution1047 {

    public static String removeDuplicates(String s) {

        Deque<Character> stack = new LinkedList<>();
        stack.addLast(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == stack.peekLast()) {
                stack.pollLast();
            } else {
                stack.addLast(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollFirst());
        }
        return res.toString();
    }

}
