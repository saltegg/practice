package fzu.com.lc.pre200;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution678 {


    public boolean checkValidString(String s) {

        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.add(i);
            } else if (s.charAt(i) == '*') {
                star.add(i);
            } else {
                if (left.isEmpty() && star.isEmpty()) return false;
                if (!left.isEmpty()) {
                    left.pollLast();
                } else {
                    star.pollLast();
                }
            }
        }
        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pollLast() > star.pollLast()) return false;
        }
        return left.isEmpty();
    }
}
