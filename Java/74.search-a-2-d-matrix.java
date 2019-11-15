/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (35.07%)
 * Likes:    1110
 * Dislikes: 131
 * Total Accepted:    261.6K
 * Total Submissions: 737.4K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 * 
 */

// @lc code=start
class Solution {
    /* O(log(mn)) */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int R = matrix.length, C = matrix[0].length;
        int le = 0, ri = R * C - 1;
        while (le <= ri) {
            int mid = (ri + le) / 2;
            int cur = matrix[mid / C][mid % C];
            if (cur == target) return true;
            if (cur < target) le = mid + 1;
            else ri = mid - 1;
        }
        return false;
    }

    // /* O(m+n) */
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     if (matrix.length == 0) return false;
        
    //     int r = 0, c = matrix[0].length - 1;
    //     while (r < matrix.length && c >= 0) {
    //         int cur = matrix[r][c];
    //         if (cur == target) return true;
    //         if (cur < target) r++;
    //         else c--;
    //     }
    //     return false;
    // }
}
// @lc code=end
