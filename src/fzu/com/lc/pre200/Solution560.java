package fzu.com.lc.pre200;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: linxiaohui
 * @Date: 2021/11/08 13:10
 * @Description: leetcode 560 和为k的子数组
 */
public class Solution560 {

    public int subarraySum(int[] nums, int k) {

        /*int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i]; // 前i个数的和
        }*/
        int preSum0_i = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            preSum0_i += num;
            int preSum0_j = preSum0_i - k;
            if (map.containsKey(preSum0_j)) {
                res += map.get(preSum0_j);
            }
            map.put(preSum0_i, map.getOrDefault(preSum0_i, 0) + 1);
        }
        return res;
    }
}
