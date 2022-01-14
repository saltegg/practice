package fzu.com.codetop;

public class Solution169 {

    public int majorityElement(int[] nums) {

        int cnt = 1, tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                tmp = nums[i];
                cnt = 1;
                continue;
            }
            if (tmp == nums[i]) cnt++;
            else cnt--;
        }
        return tmp;
    }

}
