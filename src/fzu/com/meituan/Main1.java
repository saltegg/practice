package fzu.com.meituan;

import java.util.*;
import java.lang.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        int d = sc.nextInt(), e = sc.nextInt(), f = sc.nextInt();   // d是衬衫
        int g = sc.nextInt();
        int[][] t = {{e, a}, {f, b}, {g, c}};
        Arrays.sort(t, ((o1, o2) -> o2[0] - o1[0]));
        int k = 0;
        long ans = 0;
        while (d > 0 && k < 3) {
            int x = t[k][0], y = t[k][1];
            if (d >= y) {
                ans += (long) y * x;
                d -= y;
            } else {
                ans += (long) d * x;
                d = 0;
            }
            k++;
        }
        System.out.println(ans);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        boolean[] rowSuo = new boolean[m + 1];
        boolean[] beijie = new boolean[m + 1];
        Map<Integer, Integer> hashMap = new HashMap<>();
        sc.nextLine();
        while (q-- > 0) {
            String line = sc.nextLine();
            String[] nums = line.split(" ");
            if (nums[0].equals("1")) {
                int x = Integer.parseInt(nums[1]);
                int y = Integer.parseInt(nums[2]);
                if (!rowSuo[x] && !rowSuo[y] && !beijie[x]) {
                    hashMap.put(x, y);
                }
            } else if (nums[0].equals("2")) {
                int y = Integer.parseInt(nums[1]);
                rowSuo[y] = true; // 加锁
            } else if (nums[0].equals("3")) {
                int y = Integer.parseInt(nums[1]);
                rowSuo[y] = false; // 去锁
            } else if (nums[0].equals("4")) {
                int x = Integer.parseInt(nums[1]);
                if (hashMap.containsKey(x) && !rowSuo[hashMap.get(x)] && !beijie[x]) {
                    System.out.println(hashMap.get(x));
                    beijie[x] = true;
                } else {
                    System.out.println(-1);
                }
            } else {
                int x = Integer.parseInt(nums[1]);
                beijie[x] = false;
            }
        }
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int[] dp = new int[n];
        dp[0] = str.charAt(0) == 'E'? 1 : -1;
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            char c = str.charAt(i);
            if (c == 'E') {
                dp[i] = Math.max(dp[i - 1] + 1, 1);
            } else {
                dp[i] = dp[i - 1] - 1;
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);


    }
}
