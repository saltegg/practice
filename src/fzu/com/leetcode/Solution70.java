package fzu.com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution70 {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static int climbStairs(int n) {

        if (n == 1) return 1;

        if (n == 2) return 2;

        if (map.containsKey(n)) return map.get(n);

        int ans = climbStairs(n - 1) + climbStairs(n - 2);

        map.put(n, ans);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }
}
