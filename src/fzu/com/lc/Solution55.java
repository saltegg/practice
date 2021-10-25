package fzu.com.lc;

public class Solution55 {

    /*private boolean isCan = false;

    public void dfs(int pos, int[] nums, boolean isCan) {
        if (pos >= nums.length - 1) {
            this.isCan = true;
            return;
        }
        for (int i = nums[pos]; i >= 1; i--) {
            dfs(pos + i, nums, isCan);
            if (this.isCan) return;
        }
    }*/   //这种方法超时， 第74/75个样例过不了

    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
            if (k >= nums.length - 1) return true;
        }
        return true;
    }   /* 种方法所依据的核心特性：如果一个位置能够到达，那么这个位置左侧所有位置都能到达。*/

    public static void main(String[] args) {

    }

}
