package fzu.com.lc.pre200;

import java.util.Arrays;

public class Interview1714 {

    private static int partition(int[] arr, int l, int r) {
        int tmp = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= tmp) r--;
            if (l < r) arr[l] = arr[r];
            while (l < r && arr[l] < tmp) l++;
            if (l < r) arr[r] = arr[l];
        }
        arr[l] = tmp;
        return l;
    }

    public static int[] smallestK(int[] arr, int k) {

        int l = 0, r= arr.length - 1;
        while (l < r) {
            int mid = partition(arr, l, r);
            if (mid == k) return Arrays.copyOf(arr, k);
            else if (mid > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return Arrays.copyOf(arr, l);
    }

    public static void main(String[] args) {
        smallestK(new int[]{1,3,5,7,2,4,6,8}, 4);
    }
}
