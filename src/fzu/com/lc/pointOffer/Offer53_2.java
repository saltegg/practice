package fzu.com.lc.pointOffer;

public class Offer53_2 {

    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (!(i == nums[i])) return i;
            i++;
        }
        return i;
    }
}
