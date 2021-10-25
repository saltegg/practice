package fzu.com.lc.pre200;

import java.util.ArrayDeque;
import java.util.Deque;

public class Competition261 {

    public int minimumMoves(String s) {
        int cnt = 0, r = 0;
        while (r < s.length()){
            if (s.charAt(r) == 'X') {
                cnt++;
                r += 3;
            } else {
                r++;
            }
        }
        return cnt;
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {

        int m = rolls.length;
        int len = n + m;
        int sum = len * mean, sumRolls = 0;
        for (int roll : rolls) {
            sumRolls += roll;
        }
        int sumN = sum - sumRolls;
        if (sumN < 0 || sumN > n * 6 || sumN / n == 0) {
            return new int[]{};
        }
        int a = sumN / n;
        int mod = sumN % n;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = a;
            if (mod > 0) {
                ans[i]++;
                mod--;
            }
        }
        return ans;
    }

    public boolean stoneGameIX(int[] stones) {

        int[] s = {0, 0, 0};
        for (int i : stones) ++s[i % 3];
        if (s[0] % 2 == 0) return s[1] != 0 && s[2] != 0;
        return s[2] > s[1] + 2 || s[1] > s[2] + 2;
    }

    public String smallestSubsequence(String s, int k, char letter, int repetition) {

        int n = s.length(), cnt = 0, p = 0;
        int del = n - k;  // 需要删除n - k个字符，最后剩k个字符
        Deque<Character> stack = new ArrayDeque<>(); // 单调栈的栈
        for (char c : s.toCharArray()) {
            if (c == letter) cnt++; // letter在s中总共出现了几次
        }

        for (int i = 0; i < n; i++) { // 单调栈
            while (!stack.isEmpty() && del > 0 && stack.peekLast() > s.charAt(i)) {
                if (stack.peekLast() == letter) {
                    if (cnt + p <= repetition) {
                        break;
                    }
                    p--;
                }
                stack.pollLast();
                del--;
            }
            if (s.charAt(i) == letter) {
                cnt--;
                p++;
            }
            stack.add(s.charAt(i));
        }

        StringBuilder ans = new StringBuilder();
        p = 0;

        while (!stack.isEmpty() && ans.length() < k){
            if (stack.peekFirst() == letter) p++;
            ans.append(stack.pollFirst());
        }

        for (int i = k - 1; i >= 0; i--) {
            if (p < repetition && ans.charAt(i) != letter) {
                ans.replace(i, i + 1, String.valueOf(letter));
                p++;
            }
        }
        return ans.toString();
    }
}
