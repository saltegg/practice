package fzu.com.lc.dp;
 
//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 631 👎 0

public class PartitionEqualSubsetSum{
    public static void main(String[] args) {

        Solution solution = new PartitionEqualSubsetSum().new Solution();

        int[] t = {2, 2, 1, 1};
        System.out.println(solution.canPartition(t));
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int v : nums) {
            sum += v;
        }
        if (sum % 2 == 1) return false;
        else sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) dp[i][j] = dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][sum];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}