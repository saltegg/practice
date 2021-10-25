package fzu.com.lc.pointOffer;
 
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 56 👎 0

public class TiHuanKongGeLcof{
    public static void main(String[] args) {
	    Solution solution = new TiHuanKongGeLcof().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        String str = "%20";
        StringBuilder sb = new StringBuilder();
        for (char v : s.toCharArray()) {
            if (v == ' ') sb.append(str);
            else sb.append(v);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}