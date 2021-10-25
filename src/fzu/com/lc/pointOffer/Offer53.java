package fzu.com.lc.pointOffer;

public class Offer53 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                for (int i = mid; i >= lo &&nums[i] == target; i--) ans++;
                for (int i = mid + 1; i <= hi && nums[i] == target; i++) ans++;
                break;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
