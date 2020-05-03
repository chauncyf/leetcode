/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (41.12%)
 * Likes:    3314
 * Dislikes: 74
 * Total Accepted:    287.6K
 * Total Submissions: 689.6K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4. 
 * 
 * Note: 
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length.
 * Your algorithm should run in O(n^2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] maxTill = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            maxTill[i] = 1;  // sequence with only itself
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && maxTill[i] < maxTill[j] + 1) {  // if num @i > num @j && length of seq @j + 1 (1 is i itself) > seq @i
                    maxTill[i] = maxTill[j] + 1;
                }
            }
            max = Math.max(max, maxTill[i]);
        }
        return max;
    }
}
// @lc code=end
