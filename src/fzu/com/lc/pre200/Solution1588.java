package fzu.com.lc.pre200;

public class Solution1588 {

    public int sumOddLengthSubarrays(int[] arr) {

        int sum = 0;
        for (int i = 1; i <= arr.length; i += 2) { // 奇数步长
            for (int j = 0; j < arr.length; j++) {
                if (j + i <= arr.length) {
                    for (int k = j; k < j + i; k++) {
                        sum += arr[k];
                    }
                }
            }
        }
        return sum;
    }
}
