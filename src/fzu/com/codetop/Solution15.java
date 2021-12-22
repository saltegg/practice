package fzu.com.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] > 0) continue;
            if (idx > 0 && nums[idx - 1] == nums[idx]) continue;
            int i = idx + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[idx] + nums[i] + nums[j];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[idx], nums[i], nums[j]));
                    j--;
                    while (i < j && nums[j + 1] == nums[j]) j--;
                    i++;
                    while (i < j && nums[i - 1] == nums[i]) i++;
                } else if (sum > 0) {
                    j--;
                    while (i < j && nums[j + 1] == nums[j]) j--;
                } else {
                    i++;
                    while (i < j && nums[i - 1] == nums[i]) i++;
                }
            }
        }
        return res;
    }
}
