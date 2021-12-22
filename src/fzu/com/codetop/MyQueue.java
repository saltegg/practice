package fzu.com.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        stack1.addFirst(x);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pollFirst();
        }
        while (!stack1.isEmpty()) {
            stack2.addFirst(stack1.pollFirst());
        }
        return stack2.pollFirst();
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peekFirst();
        } else {
            return stack1.peekLast();
        }
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
