package fzu.com.solution.bi;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

public class Solution209 {

    /**
     * 举个例子，比如排序数组 [2，5，7，10，15，18，20]
     * 如果我们查找 18，因为有这个数会返回 18 的下标 5，如果我们查找 9，
     * 因为没这个数会返回 -4（至于这个是怎么得到的，大家可以看下源码，这里不再过多展开讨论），
     * 我们对他取反之后就是3，也就是说如果我们在数组中添加一个 9，他在数组的下标是 3，也就是第 4 个位置
     * （也可以这么理解，只要取反之后不是数组的长度，那么他就是原数组中第一个比他大的值的下标）
     *
     * 前缀和 + 二分搜索的题目（******）
     */

    public int minSubArrayLen(int target, int[] nums) {   // 必须全为正数
        int res = Integer.MAX_VALUE;
        int length = nums.length;
        int[] sum = new int[length + 1];
        for (int i = 1; i <= length; i++) sum[i] = sum[i - 1] + nums[i - 1];
        for (int i = 0; i <= length; i++) {
            int s = target + sum[i];
            int idx = Arrays.binarySearch(sum, s);  // 插入位置
            if (idx < 0) {
                idx = ~idx;  // 看上面注解
            }
            if (idx <= length) {
                res = Math.min(res, idx - i);
            }
        }
        return res == Integer.MAX_VALUE? 0 : res;
    }
}
