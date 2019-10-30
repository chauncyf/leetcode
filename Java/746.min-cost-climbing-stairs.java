/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 *
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 *
 * algorithms
 * Easy (47.78%)
 * Likes:    1300
 * Dislikes: 302
 * Total Accepted:    103.2K
 * Total Submissions: 213.7K
 * Testcase Example:  '[0,0,0,0]'
 *
 * 
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0
 * indexed).
 * 
 * Once you pay the cost, you can either climb one or two steps. You need to
 * find minimum cost to reach the top of the floor, and you can either start
 * from the step with index 0, or the step with index 1.
 * 
 * 
 * Example 1:
 * 
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the
 * top.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping
 * cost[3].
 * 
 * 
 * 
 * Note:
 * 
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 1) return 0;
        int n1 = 0, n2 = 0;
        for (int i = 0; i < cost.length; i++) {
            int curMin = cost[i] + Math.min(n1, n2);
            n2 = n1;
            n1 = curMin;
        }
        return Math.min(n1, n2);
    }

    // public int minCostClimbingStairs(int[] cost) {
    //     return Math.min(findMinCost(cost, 0, 0), findMinCost(cost, 0, 1));
    // }
    // private int findMinCost(int[] cost, int sum, int i) {
    //     if (i >= cost.length) return sum;
    //     return Math.min(findMinCost(cost, sum + cost[i], i + 1), findMinCost(cost, sum + cost[i], i + 2));
    // }
}
// @lc code=end
