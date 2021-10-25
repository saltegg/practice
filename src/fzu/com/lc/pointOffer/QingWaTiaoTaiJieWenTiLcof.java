package fzu.com.lc.pointOffer;
 
//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 104 👎 0

import java.util.Map;

public class QingWaTiaoTaiJieWenTiLcof{
    public static void main(String[] args) {
	    Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return n;
        int dp1 = 1, dp2 = 2;
        for (int i = 2; i < n; i++) {
            int q = dp2;
            dp2 = (dp1 + dp2) % (int)(1e9 + 7);
            dp1 = q;
        }
        return dp2;
    }

    private int func(int n, Map<Integer, Integer> map) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) return map.get(n);
        int a = func(n - 1, map);
        int b = func(n - 2, map);
        map.put(n, a + b);
        return a + b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}