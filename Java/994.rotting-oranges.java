/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 *
 * https://leetcode.com/problems/rotting-oranges/description/
 *
 * algorithms
 * Easy (46.46%)
 * Likes:    772
 * Dislikes: 95
 * Total Accepted:    43.4K
 * Total Submissions: 92.2K
 * Testcase Example:  '[[2,1,1],[1,1,0],[0,1,1]]'
 *
 * In a given grid, each cell can have one of three values:
 * 
 * 
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * 
 * 
 * Every minute, any fresh orange that is adjacent (4-directionally) to a
 * rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange.  If this is impossible, return -1 instead.
 * 
 * 
 * Example 1:
 * 
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is
 * never rotten, because rotting only happens 4-directionally.
 * 
 * 
 * Example 3:
 * 
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the
 * answer is just 0.
 * 
 * 
 * Note:
 * 
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 * 
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) fresh++;
                if (grid[row][col] == 2) {
                    queue.offer(new Integer[]{row, col});
                }
            }
        }
        int min = 0;
        while (!queue.isEmpty()) {
            int rotNum = queue.size();
            for (int i = 0; i < rotNum; i++) {
                Integer[] rot = queue.poll();
                int r = rot[0], c = rot[1];
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    queue.offer(new Integer[]{r - 1, c});
                    grid[r - 1][c] = 2;
                    fresh--;
                }
                if (r + 1 < grid.length && grid[r + 1][c] == 1) {
                    queue.offer(new Integer[]{r + 1, c});
                    grid[r + 1][c] = 2;
                    fresh--;
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    queue.offer(new Integer[]{r, c - 1});
                    grid[r][c - 1] = 2;
                    fresh--;   
                }
                if (c + 1 < grid[0].length && grid[r][c + 1] == 1) {
                    queue.offer(new Integer[]{r, c + 1});
                    grid[r][c + 1] = 2;
                    fresh--;
                }
            }
            if (!queue.isEmpty()) min++;
        }
        return (fresh == 0) ? min : -1;
    }
}
// @lc code=end
