package fzu.com.codetop;

import java.util.HashMap;
import java.util.Map;

public class Solution560 {

    public int subarraySum(int[] nums, int k) {

        int res = 0;
        int[] sum = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            int t = sum[i] - k;
            if (map.containsKey(t)) {
                res += map.get(t);
            }
            int c = map.getOrDefault(sum[i], 0);
            map.put(sum[i], c + 1);
        }
        return res;
    }
}
