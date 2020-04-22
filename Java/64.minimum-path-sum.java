/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (47.84%)
 * Likes:    2462
 * Dislikes: 53
 * Total Accepted:    357.6K
 * Total Submissions: 682K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

// @lc code=start
class Solution {    
    private int[][] memo;
    
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        
        memo = new int[grid.length][grid[0].length];        
        return dfs(grid, 0, 0);
    }
    
    // it's a kind of binary tree
    // how to ensure reach the bottom right note?
    private int dfs(int[][] grid, int r, int c) {
        if (r >= grid.length || c >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        
        if (r == grid.length - 1 && c == grid[0].length - 1) {      
            return grid[r][c];
        }
        
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
            
        memo[r][c] = Math.min(dfs(grid, r + 1, c), dfs(grid, r, c + 1)) + grid[r][c];
        
        return memo[r][c];        
    }
}
// @lc code=end
