package fzu.com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

public class Solution225 {

    private List<Integer> stack;

    /** Initialize your data structure here. */
    public Solution225() {
        this.stack = new ArrayList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.stack.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int lastOne = this.stack.get(stack.size() - 1);
        this.stack.remove(stack.size() - 1);
        return  lastOne;
    }

    /** Get the top element. */
    public int top() {
        return this.stack.get(stack.size() - 1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.size() == 0;
    }

    public static void main(String[] args) {

    }
}
