/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 *
 * https://leetcode.com/problems/single-number/description/
 *
 * algorithms
 * Easy (60.86%)
 * Likes:    3754
 * Dislikes: 145
 * Total Accepted:    690.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '[2,2,1]'
 *
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 * 
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        /* Use bitwise XOR to solve this problem

            0 ^ N = N
            N ^ N = 0

            So..... if N is the single number
            
            N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
            = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
            = 0 ^ 0 ^ ..........^ 0 ^ N
            = N
        */
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}
// @lc code=end
