package fzu.com.lc.pointOffer;
 
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 186 👎 0

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args) {
	    Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 要点：二叉搜索树中根节点的值大于左子树中每个节点的值，小于右子树中每个节点的值
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) return true;
        return iSverifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean iSverifyPostorder(int[] postorder, int l, int r) {
        if (l >= r) return true;
        int k = r;
        for (int i = l; i < r; i++) {
            // 从当前区域找到第一个大于根节点的，说明后续区域数值都在右子树中
            if (postorder[i] >= postorder[r]) {
                k = i;
                break;
            }
        }
        for (int i = k; k < r; k++) {
            // 进行判断后续的区域是否所有的值都是大于当前的根节点，如果出现小于的值就直接返回false
            if (postorder[k] < postorder[r]) return false;
        }
        if (!iSverifyPostorder(postorder, l, k - 1)) return false; // 检查左数
        if (!iSverifyPostorder(postorder, k, r - 1)) return false; // 检查右树
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}