package fzu.com.lc.pre200;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution150 {

    public static int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                int b = deque.pollLast();
                int a = deque.pollLast();
                switch (token) {
                    case "+":
                        deque.addLast(a + b);
                        break;
                    case "-":
                        deque.addLast(a - b);
                        break;
                    case "*":
                        deque.addLast(a * b);
                        break;
                    case "/":
                        deque.addLast(a / b);
                        break;
                }
            } else {
                deque.addLast(Integer.parseInt(token));
            }
        }
        return deque.pollLast();
    }

    public static void main(String[] args) {
        evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
    }
}
