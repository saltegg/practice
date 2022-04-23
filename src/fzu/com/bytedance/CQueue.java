package fzu.com.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public CQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.addLast(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty() && stack1.isEmpty()) return -1;
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.pollLast());
            }
        }
        return stack2.pollLast();
    }
}
