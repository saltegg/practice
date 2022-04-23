package fzu.com.meituan;

import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- >0) {
            int n = sc.nextInt();
            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();
            int[] v2 = new int[2 * n];
            int k = 0;
            for (int i = 0; i < 2 * n; i++) {
                v2[i] = v[k++];
                if (k == n) k = 0;
            }
            int ans = 0;
            for (int i = 0; i <= n - 1; i++) {
                int t = v2[i];
                int res = Math.max(0, v2[i]);
                for (int j = i + 1; j < i + n ; j++) {
                    t = Math.max(t + v2[j], v2[j]);
                    res = Math.max(res, t);
                }
                ans = Math.max(ans, res);
            }
            System.out.println(ans);
        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int p = array.length - x;
        int t = array[p];
        if (t != 0) {
            while (p - 1 >= 0 && array[p - 1] == t) {
                p--;
            }
        } else {
            while (array[p] == 0) {
                p++;
            }
        }
        System.out.println(array.length - p);
    }


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[4];
        while (sc.hasNext()) {
            for (int i = 0; i < 4; i++) {
                array[i] = sc.nextInt();
            }
            int n = array[0], m = array[1];
            int a = array[2], b = array[3];
            int[] w = new int[m];
            for (int i = 0; i < m; i++) {
                w[i] = sc.nextInt();
            }
            if (a > b) {
                int t = b;
                b = a;
                a = t;
            }
            Arrays.sort(w);
            int low = w[0], high = w[w.length - 1];
            if (n == m) {
                if (low == a && high == b) System.out.println("YES");
                else System.out.println("NO");
            } else if (n - 1 == m) {
                if ((low == a && high <= b) || (low >= a && high == b)) System.out.println("YES");
                else System.out.println("NO");
            } else {
                if (low >= a && high <= b) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
