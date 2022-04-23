package fzu.com.bytedance;

public class Solution152 {

    public int maxProduct(int[] nums) {

        int res = Integer.MIN_VALUE, curMin = 1, curMax = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(curMax * num, num);
            curMin = Math.min(curMin * num, num);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
