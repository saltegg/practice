package fzu.com.lc;

import java.util.Arrays;

public class Solution169 {

    /*
    摩尔投票法:
    投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
    且“多数元素”的个数 > ⌊ n/2 ⌋，其余元素的个数总和 <= ⌊ n/2 ⌋。
    因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
    这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     */
    public int majorityElement(int[] nums) {
        int c = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                c = nums[i];
                continue;
            }
            if (c == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return c;
    }
    /*
    排序法：
    既然数组中有出现次数> ⌊ n/2 ⌋的元素，那排好序之后的数组中，相同元素总是相邻的。
    即存在长度> ⌊ n/2 ⌋的一长串 由相同元素构成的连续子数组。
     */

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

}
