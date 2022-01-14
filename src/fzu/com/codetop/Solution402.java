package fzu.com.codetop;

import java.util.Deque;
import java.util.LinkedList;

public class Solution402 {

    public String removeKdigits(String num, int k) {

        Deque<Integer> stack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';
            while (!stack.isEmpty() && k > 0 && cur < stack.peekLast()) {
                stack.pollLast();
                k--;
            }
            if (cur != 0 || !stack.isEmpty()) {
                stack.addLast(cur);
            }
        }
        while (k > 0) {
            stack.pollLast();
            k--;
        }
        if (stack.isEmpty()) return "0";
        for (Integer d : stack) {
            res.append(d);
        }
        return res.toString();
    }
}
