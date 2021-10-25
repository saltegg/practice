package fzu.com.lc.pre200;

public class Solution80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int k = 1, count = 1, tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count >= 2) {
                if (nums[i] == tmp) {
                    count++;
                    k++;
                } else {
                    tmp = nums[i];
                    nums[k++] = nums[i];
                    count = 1;
                }
                continue;
            }
            if (nums[i] == tmp) {
                count++;
            } else {
                tmp = nums[i];
                count = 1;
            }
            nums[k++] = nums[i];
        }
        return k;
    }
}
