/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 *
 * https://leetcode.com/problems/contiguous-array/description/
 *
 * algorithms
 * Medium (43.07%)
 * Likes:    1459
 * Dislikes: 83
 * Total Accepted:    87.5K
 * Total Submissions: 213.1K
 * Testcase Example:  '[0,1]'
 *
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1. 
 * 
 * 
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of
 * 0 and 1.
 * 
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal
 * number of 0 and 1.
 * 
 * Note:
 * The length of the given binary array will not exceed 50,000.
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
// @lc code=end
