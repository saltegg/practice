package fzu.com.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[i] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                } else if (sum > 0) {
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else {
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        threeSum(new int[]{0, 0, 0});
    }
}
