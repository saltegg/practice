package fzu.com.lc.array;
 
//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻的孩子中，评分高的孩子必须获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 示例 1: 
//
// 输入: [1,0,2]
//输出: 5
//解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2: 
//
// 输入: [1,2,2]
//输出: 4
//解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 413 👎 0

import java.util.Arrays;

public class Candy{
    public static void main(String[] args) {

        Solution solution = new Candy().new Solution();
        int[] t = {1,2,87,87,87,2,1};
        //solution.candy(t);
        System.out.println(solution.candy(t));
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {

        if (ratings.length == 1) return 1;
        int sum = 0;
        int[] sugar = new int[ratings.length];
        Arrays.fill(sugar, 1);
        
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                if (ratings[i] < ratings[i + 1] && sugar[i] >= sugar[i + 1]) {
                    sugar[i + 1] = sugar[i] + 1;
                }
            } else if (i == ratings.length - 1) {
                if (ratings[i] < ratings[i - 1] && sugar[i - 1] <= sugar[i]) {
                    sugar[i - 1] = sugar[i] + 1;
                }
            } else {
                if (ratings[i] < ratings[i - 1] && sugar[i - 1] <= sugar[i]) {
                    sugar[i - 1] = sugar[i] + 1;
                }
                if (ratings[i] < ratings[i + 1] && sugar[i] >= sugar[i + 1]) {
                    sugar[i + 1] = sugar[i] + 1;
                }
            }
        }
        
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i == 0) {
                if (ratings[i] < ratings[i + 1] && sugar[i] >= sugar[i + 1]) {
                    sugar[i + 1] = sugar[i] + 1;
                }
            } else if (i == ratings.length - 1) {
                if (ratings[i] < ratings[i - 1] && sugar[i - 1] <= sugar[i]) {
                    sugar[i - 1] = sugar[i] + 1;
                }
            } else {
                if (ratings[i] < ratings[i - 1] && sugar[i - 1] <= sugar[i]) {
                    sugar[i - 1] = sugar[i] + 1;
                }
                if (ratings[i] < ratings[i + 1] && sugar[i] >= sugar[i + 1]) {
                    sugar[i + 1] = sugar[i] + 1;
                }
            }
        }
        for (int v : sugar) {
            sum += v;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}