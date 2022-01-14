package fzu.com.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution394 {

    public String decodeString(String s) {

        int multi = 0;
        Deque<String> stackStr = new ArrayDeque<>();
        Deque<Integer> stackInt = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stackStr.addLast(res.toString());
                stackInt.addLast(multi);
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                int tmp = stackInt.pollLast();
                for (int i = 0; i < tmp; i++) {
                    sb.append(res);
                }
                res = new StringBuilder(stackStr.pollLast() + sb);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + c - '0';  // 字符串的重复个数可能大于10，两位数以上
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
