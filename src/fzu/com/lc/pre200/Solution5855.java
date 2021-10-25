package fzu.com.lc.pre200;

import java.util.Arrays;
import java.util.Comparator;

public class Solution5855 {

    public static int getPartition(String[] nums, int left, int right) {
        String tmp = nums[left];
        while (left < right) {
            while (left < right && compare(nums[right], tmp) > 0) right--;
            if (left < right) nums[left] = nums[right];
            while (left < right && compare(nums[left], tmp) < 0) left++;
            if (left < right) nums[right] = nums[left];
        }
        nums[left] = tmp;
        return left;
    }

    private static int compare(String a, String b) {
        if (a.length() != b.length()) {
            if (a.length() > b.length()) return 1;
            else return -1;
        } else {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) - '0' < b.charAt(i) - '0') return -1;
                else if (a.charAt(i) - '0' > b.charAt(i) - '0')return 1;
            }
            return 1;
        }
    }

    public static String kthLargestNumber(String[] nums, int k) { // 超时

        int l = 0, r = nums.length - 1, target = nums.length - k;
        while (l < r) {
            int mid = getPartition(nums, l, r);
            if (mid == target) {
                return nums[mid];
            } else if (mid < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }

    public static String kthLargestNumber1(String[] nums, int k) {

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    if (a.length() > b.length()) return -1;
                    else return 1;
                } else {
                    for (int i = 0; i < a.length(); i++) {
                        if (a.charAt(i) - '0' < b.charAt(i) - '0') return 1;
                        else if (a.charAt(i) - '0' > b.charAt(i) - '0')return -1;
                    }
                    return 0;
                }
            }
        });
        return nums[nums.length - k];
    }
}
