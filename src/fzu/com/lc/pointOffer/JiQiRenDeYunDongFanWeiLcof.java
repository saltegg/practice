package fzu.com.lc.pointOffer;
 
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 202 👎 0

public class JiQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args) {
	    Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int ans = 0;
    private int[] dir = {-1, 0, 1, 0, -1};

    private int getSum(int x) {
        int sum = 0;
        while(x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    private void dfs(int m, int n, int k, boolean[][] visited, int x, int y) {
        if (getSum(x) + getSum(y) > k) return;
        ans++;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int r = x + dir[i];
            int c = y + dir[i + 1];
            if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                dfs(m, n, k, visited, r, c);
            }
        }
        //visited[x][y] = false;
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(m, n, k, visited, 0, 0);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}