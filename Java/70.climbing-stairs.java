/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (44.65%)
 * Likes:    2790
 * Dislikes: 98
 * Total Accepted:    496.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '2'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 */

// @lc code=start
class Solution {
    /* Bottom Up Solution */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int n_2 = 1;
        int n_1 = 2;
        for (int i = 3; i <= n; i++) {
            int curWays = n_1 + n_2;
            n_2 = n_1;
            n_1 = curWays;
        }
        return n_1;
    }

    // /* Recursive Solution */
    // public int climbStairs(int n) {
    //     if (n == 0 || n == 1) return 1;
    //     return climbStairs(n - 1) + climbStairs(n - 2);
    // }

    /* Recursive Solutoin with Memo */
    // private Map<Integer, Integer> memo = new HashMap<>();
    // public int climbStairs(int n) {
    //     if (n == 0 || n == 1) return 1;
    //     if (memo.containsKey(n)) return memo.get(n);    
    //     int stairs = climbStairs(n - 1) + climbStairs(n - 2);
    //     memo.put(n, stairs);
    //     return stairs;
    // }   
}
// @lc code=end
