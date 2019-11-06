/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (47.49%)
 * Likes:    636
 * Dislikes: 90
 * Total Accepted:    159.1K
 * Total Submissions: 320.9K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n^2 in spiral order.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int left = 0, right = n - 1;
        int up = 0, down = n - 1;
        int i = 1;
        while (i <= n * n) {
            for (int c = left; c <= right && i <= n * n; c++) {
                res[up][c] = i++;
            }
            for (int r = up + 1; r <= down - 1 && i <= n * n; r++) {
                res[r][right] = i++;
            }
            for (int c = right; c >= left && i <= n * n; c--) {
                res[down][c] = i++;
            }
            for (int r = down - 1; r >= up + 1 && i <= n * n; r--) {
                res[r][left] = i++;
            }
            left++;
            right--;
            up++;
            down--;
        }
        
        return res;
    }
}
// @lc code=end
