package fzu.com.bytedance;

public class Solution41 {

    public int firstMissingPositive(int[] nums) {

        /**
         * 由于数组的长度为n， 索引缺失的正整数必定是在1 - n之间， 如果1 - n都没缺失，那么答案就是 n + 1了
         * 如果是第一种情况的话， 只需要把数组中大于等于1和小于等于数组长度的值放到相应的位置上就可以了，然后再次
         * 遍历数组，找到第一个下标和相应值不等的那个，就是最终答案了。
         */

        int len = nums.length;
        int i = 0;
        while (i < len) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = tmp;
            }
            i++;
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }
}
