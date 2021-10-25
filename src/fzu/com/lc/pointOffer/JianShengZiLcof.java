package fzu.com.lc.pointOffer;
 
//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
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
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 141 👎 0

public class JianShengZiLcof{
    public static void main(String[] args) {

        Solution solution = new JianShengZiLcof().new Solution();
        solution.cuttingRope(2);
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int maxV = Integer.MIN_VALUE;

    private void dfs(int n, int m, int dot) {  // 超时
        if (m > 1 && n == 0) {
            maxV = Math.max(maxV, dot);
            return;
        }
        for (int i = 1; i <= n; i++) {
            dot *= i;
            dfs(n - i, m + 1, dot);
            dot /= i;
        }
    }

    /*public int cuttingRope(int n) {
        dfs(n, 0, 1);
        return maxV;
    }*/

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1; // dp[i] 表示将i分解能得到的最大乘积
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = 0;
            for (int j = 1; j < i; j++) { // dp[i - j] 表示分解后的最大值， (i - j)则表示不分解， 取大的一个
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, j * (i - j)));
            }
        }
        return dp[n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}