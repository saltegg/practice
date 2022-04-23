package fzu.com.solution.bi;

public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                int t = mid;
                while (t < r && nums[t + 1] == target) t++;
                while (mid > l && nums[mid - 1] == target) mid--;
                res[0] = mid;
                res[1] = t;
                return res;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public int[] searchRange1(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length  == 0) return res;   // 寻找左边界
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l == nums.length || nums[l] != target) return res;
        res[0] = l;
        r = nums.length;        // 寻找有边界， 基本思想：找到右边第一个不等于目标值的下表， 最终答案为l - 1
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        res[1] = l - 1;
        return res;
    }
}
