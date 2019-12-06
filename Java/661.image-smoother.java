/*
 * @lc app=leetcode id=661 lang=java
 *
 * [661] Image Smoother
 *
 * https://leetcode.com/problems/image-smoother/description/
 *
 * algorithms
 * Easy (49.18%)
 * Likes:    199
 * Dislikes: 905
 * Total Accepted:    40.9K
 * Total Submissions: 82.2K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given a 2D integer matrix M representing the gray scale of an image, you
 * need to design a smoother to make the gray scale of each cell becomes the
 * average gray scale (rounding down) of all the 8 surrounding cells and
 * itself.  If a cell has less than 8 surrounding cells, then use as many as
 * you can.
 * 
 * Example 1:
 * 
 * Input:
 * [[1,1,1],
 * ⁠[1,0,1],
 * ⁠[1,1,1]]
 * Output:
 * [[0, 0, 0],
 * ⁠[0, 0, 0],
 * ⁠[0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * 
 * 
 * 
 * Note:
 * 
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        for (int r = 0; r < M.length; r++) {
            for (int c = 0; c < M[0].length; c++) {
                int count = 0;
                for (int ir = r - 1; ir <= r + 1; ir++) {
                    for (int ic = c - 1; ic <= c + 1; ic++) {
                        if (ir >= 0 && ir < M.length && ic >= 0 && ic < M[0].length) {
                            res[r][c] += M[ir][ic];
                            count++;
                        }
                    }
                }
                res[r][c] /= count;
            }
        }
        return res;
    }
}
// @lc code=end
