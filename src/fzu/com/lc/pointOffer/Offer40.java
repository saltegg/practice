package fzu.com.lc.pointOffer;

import java.util.Arrays;

public class Offer40 {

    public int[] getLeastNumbers(int[] arr, int k) {

        if (k == 0 || arr.length == 0) return new int[0];
        int l = 0, r = arr.length - 1;
        int idx = partition(arr, l, r);
        while (idx != k - 1) {
            if (idx > k - 1) {
                r = idx - 1;
                idx = partition(arr, l, r);
            } else {
                l = idx + 1;
                idx = partition(arr, l, r);
            }
        }
        return Arrays.copyOf(arr, idx + 1);
    }

    private int partition(int[] arr, int l, int r) {
        int tmp = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= tmp) r--;
            if (l < r) arr[l++] = arr[r];
            while (l < r && arr[l] < tmp) l++;
            if (l < r) arr[r--] = arr[l];
        }
        arr[l] = tmp;
        return l;
    }
}
