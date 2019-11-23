/*
 * @lc app=leetcode id=414 lang=java
 *
 * [414] Third Maximum Number
 *
 * https://leetcode.com/problems/third-maximum-number/description/
 *
 * algorithms
 * Easy (29.27%)
 * Likes:    451
 * Dislikes: 863
 * Total Accepted:    111K
 * Total Submissions: 374.5K
 * Testcase Example:  '[3,2,1]'
 *
 * Given a non-empty array of integers, return the third maximum number in this
 * array. If it does not exist, return the maximum number. The time complexity
 * must be in O(n).
 * 
 * Example 1:
 * 
 * Input: [3, 2, 1]
 * 
 * Output: 1
 * 
 * Explanation: The third maximum is 1.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1, 2]
 * 
 * Output: 2
 * 
 * Explanation: The third maximum does not exist, so the maximum (2) is
 * returned instead.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: [2, 2, 3, 1]
 * 
 * Output: 1
 * 
 * Explanation: Note that the third maximum here means the third maximum
 * distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * 
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
                minQ.offer(i);
                if (minQ.size() > 3) minQ.poll();
            }
        }
        if (minQ.size() == 2) minQ.poll();
        return minQ.peek();
    }
}
// @lc code=end
