/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 *
 * https://leetcode.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (33.59%)
 * Likes:    2256
 * Dislikes: 57
 * Total Accepted:    193.3K
 * Total Submissions: 543.9K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * Example:
 * Input: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Output: 4
 */

// @lc code=start
class Solution {
    /* dp(i, j) = min(dp(i − 1, j), dp(i − 1, j − 1), dp(i, j − 1)) + 1 */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;
        for (int r = 1; r <= matrix.length; r++) {
            for (int c = 1; c <= matrix[0].length; c++) {
                if (matrix[r - 1][c - 1] == '1') {
                    dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
                    max = Math.max(max, dp[r][c]);
                }
            }
        }
        return max * max;
    }
}
// @lc code=end
