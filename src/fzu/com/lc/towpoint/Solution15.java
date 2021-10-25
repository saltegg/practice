package fzu.com.lc.towpoint;

import java.util.Arrays;

public class Solution15 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int s = nums[i] + nums[start] + nums[end];
                if (Math.abs(ans - target) > Math.abs(s - target)) {
                    ans = s;
                }
                if (s < target) {
                    start++;
                } else if (s > target) {
                    end--;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {-1,2,1,-4};
        //System.out.println(threeSumClosest(a, 1));
    }
}
