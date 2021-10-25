package fzu.com.lc.dp;

/*
接雨水
 */
public class Solution42 {

    public static int trap(int[] height) {
       
        int sum = 0;
        int[] a = new int[height.length];
        int[] b = new int[height.length];
       
       for (int i = 1; i < height.length - 1; i++) {
           a[i] = Math.max(a[i - 1], height[i - 1]);
       }
   
       for (int i = height.length - 2; i >= 1; i--) {
           b[i] = Math.max(b[i + 1], height[i + 1]);
       }
       
       for (int i = 1; i < height.length - 1; i++) {
           int min = Math.min(a[i], b[i]);
           if(min > height[i]) {
               sum += min - height[i];
           }
       }
       return sum;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 3};
        System.out.println(trap(a));
    }
}
