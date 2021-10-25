package fzu.com.lc.pointOffer;
 
//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 108 👎 0

public class ShuZhiDeZhengShuCiFangLcof{
    public static void main(String[] args) {

        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
        System.out.println(Math.pow(2.00000, -2147483648));
        System.out.println(solution.myPow(2.00000, -2147483648));
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double sum = 1.0;
        long t = n;
        if (n < 0) {
            x = 1 / x;
            t = -t;
        }
        while (t > 0) {
            if ((t & 1) == 1) {
                sum *= x;
            }
            x *= x;
            t >>= 1;
        }
        return sum;
    }

    public double myPow1(double x, int n) {  // 递归解法  x n次方  = (x n / 2) 2
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}