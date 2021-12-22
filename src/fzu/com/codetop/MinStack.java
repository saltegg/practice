package fzu.com.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public MinStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int val) {
        stack1.addLast(val);
        if (stack2.isEmpty() || val <= stack2.peekLast()) stack2.addLast(val);
    }

    public void pop() {
        int e = stack1.pollLast();
        if (e == stack2.peekLast()) stack2.pollLast();
    }

    public int top() {
        return stack1.peekLast();
    }

    public int getMin() {
        return stack2.peekLast();
    }
}
