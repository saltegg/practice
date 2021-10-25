package fzu.com.lc.pointOffer;

public class Offer39 {
    public int majorityElement(int[] nums) {

        int n = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == n) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                count = 1;
                n = nums[i];
            }
        }
        return n;
    }
}
