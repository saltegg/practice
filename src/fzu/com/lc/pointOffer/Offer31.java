package fzu.com.lc.pointOffer;

import java.util.Stack;

public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pos = 0;
        Stack<Integer> stack = new Stack<>();
        for (int value : pushed) {
            stack.add(value);
            while (!stack.isEmpty() && stack.peek() == popped[pos]) {
                stack.pop();
                pos++;
            }

        }
        return stack.isEmpty();
    }
}
