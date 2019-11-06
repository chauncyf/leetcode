/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (30.94%)
 * Likes:    1484
 * Dislikes: 458
 * Total Accepted:    283.4K
 * Total Submissions: 888.3K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        
        int R = matrix.length;
        int C = matrix[0].length;
        int up = 0, down = R - 1;
        int left = 0, right = C - 1;
        while (res.size() < R * C) {
            for (int c = left; c <= right && res.size() < R * C; c++) {
                res.add(matrix[up][c]);
            }
            for (int r = up + 1; r <= down - 1 && res.size() < R * C; r++) {
                res.add(matrix[r][right]);
            }
            for (int c = right; c >= left && res.size() < R * C; c--) {
                res.add(matrix[down][c]);
            }
            for (int r = down - 1; r >= up + 1 && res.size() < R * C; r--) {
                res.add(matrix[r][left]);
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
