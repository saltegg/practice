package fzu.com.lc.pointOffer;
 
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 201 👎 0

public class XuanZhuanShuZuDeZuiXiaoShuZiLcof{
    public static void main(String[] args) {
	    Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) { // 11
        /*
        https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
        solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
        题解地址
         */
        int min = Integer.MAX_VALUE, l = 0, r = numbers.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            min = Math.min(numbers[mid], min);
            if (numbers[mid] == numbers[r]) {
                r--;
            } else if (numbers[mid] < numbers[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return min;
    }

    public int minArray1(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--; // 右指针
        }
        return numbers[i];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}