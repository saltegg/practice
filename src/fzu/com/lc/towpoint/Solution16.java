package fzu.com.lc.towpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution16 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) break;  //如果nums[i] > 0 ，则三数之和必大于0
            if(i > 0 && nums[i] == nums[i - 1]) continue;  //去重
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l + 1]) l++;
                    while(l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return lists;
    }
}
