package fzu.com.lc.pointOffer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer_09 {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public Offer_09() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) return  -1;
        if (!stack2.isEmpty()) return stack2.pollLast();
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pollLast());
        }
        return stack2.pollLast();
    }
}
