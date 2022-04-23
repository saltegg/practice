package fzu.com.bytedance;

import java.util.Deque;
import java.util.LinkedList;

public class Solution394 {

    public static String decodeString(String s) {

        Deque<String> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack1.addLast(sb.toString());
                sb = new StringBuilder();
                stack2.add(num);
                num = 0;
            } else if (c == ']') {
                int t = stack2.pollLast();
                StringBuilder tmpStr = new StringBuilder();
                for (int k = 0; k < t; k++) {
                    tmpStr.append(sb);
                }
                sb = new StringBuilder(stack1.pollLast() + tmpStr);
                //stack1.addLast(p + sb);
                //sb = new StringBuilder();
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        decodeString("3[a]2[bc]");
    }
}
