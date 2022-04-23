package fzu.com.solution.bi;

public class Solution300 {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 1) return 1;
        int[] tail = new int[nums.length];  // dp[i] 长度为i+1的子序列 末尾的最小值
        tail[0] = nums[0];
        int end = 0;
        for (int num : nums) {
            if (num > tail[end]) {
                tail[++end] = num;
            } else {
                int l = 0, r = end;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (tail[mid] >= num) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                tail[l] = num;
            }
        }
        return end + 1;
    }
}
