package fzu.com;

public class Offer40 {



    public static int[] getLeastNumbers(int[] arr, int k) {

        int target = k - 1, l = 0, r = arr.length - 1;
        int[] res = new int[k];
        while (l <= r) {
            int mid = partition(arr, l, r);
            if (mid == target) {
                System.arraycopy(arr, 0, res, 0, k);
                return res;
            } else if (mid > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

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

}
