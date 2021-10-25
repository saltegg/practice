package fzu.com.lc.pointOffer;
 
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 76 👎 0

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
    public static void main(String[] args) {
	    Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp = nums[0];
        while (i < j) {
            while (i < j && nums[j] % 2 == 0) j--;
            if (i < j) nums[i] = nums[j];
            while (i < j && nums[i] % 2 == 1) i++;
            if (i < j) nums[j] = nums[i];
        }
        nums[i] = tmp;
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}