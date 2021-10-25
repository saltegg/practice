package fzu.com.lc.array;
 
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 319 👎 0

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString{
    public static void main(String[] args) {
	    Solution solution = new FirstUniqueCharacterInAString().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {

        int idx = -1;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
           if (map.containsKey(c)) {
               map.put(c, map.get(c) + 1);
           } else {
               map.put(c, 1);
           }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}