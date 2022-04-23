package fzu.com.codetop;

/**
 * @Author: linxiaohui
 * @Date: 2022/01/23 14:22
 * @Description:
 */
public class Solution55 {

    public boolean canJump(int[] nums) {

        int maxPos = 0;

        for (int i = 0; i < nums.length; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (maxPos >= nums.length - 1) return true;
            if (maxPos == i) return false;
        }
        return true;
    }
}
