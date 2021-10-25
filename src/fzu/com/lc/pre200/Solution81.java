package fzu.com.lc.pre200;

public class Solution81 {

    public boolean search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid]) {
                /**
                 * 样例：1101111
                 * nums[start] == nums[mid]说明mid后面的值全都和nums[mid]相等
                 * 不过也有可能是(1111222)，否则就是无序，而题
                 * 目表明说是有序了，并且当nums[start] == nums[mid]时，说明nums[start]不是我们要找的那个
                 * 值，此时start++，相当于去掉一个重复的干扰项
                 */
                start++;
                continue;
            }
            //前半部分有序
            if (nums[start] < nums[mid]) {
                //target在前半部分
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {  //否则，去后半部分找
                    start = mid + 1;
                }
            } else {
                //后半部分有序
                //target在后半部分
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {  //否则，去后半部分找
                    end = mid - 1;

                }
            }
        }
        return false;
    }
}
