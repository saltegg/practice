package fzu.com.lc.pointOffer;
 
//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 61 👎 0

import java.math.BigInteger;

public class JianShengZiIiLcof{
    public static void main(String[] args) {
	    Solution solution = new JianShengZiIiLcof().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = BigInteger.valueOf(1); // dp[i] 表示将i分解能得到的最大乘积
        dp[2] = BigInteger.valueOf(1);
        for (int i = 3; i <= n; i++) {
            dp[i] = BigInteger.valueOf(0);
            for (int j = 1; j < i; j++) { // dp[i - j] 表示分解后的最大值， (i - j)则表示不分解， 取大的一个
                dp[i] = dp[i].max(BigInteger.valueOf(j).multiply(dp[i - j]).max(BigInteger.valueOf(j * (i - j))));
            }
        }
        return (dp[n].mod(BigInteger.valueOf((long) (1e9 + 7)))).intValue();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}