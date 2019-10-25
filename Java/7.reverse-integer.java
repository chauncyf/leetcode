/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.41%)
 * Likes:    2540
 * Dislikes: 3959
 * Total Accepted:    841.6K
 * Total Submissions: 3.3M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 * 
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10) return 0;
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10) return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    // public int reverse(int x) {
    //     int result = 0;
    //     while (x != 0) {
    //         int tail = x % 10;
    //         // it will not equal if it's overflowed
    //         if (((result * 10 + tail) - tail) / 10 != result) return 0;
    //         result = result * 10 + tail;
    //         x /= 10;
    //     }
    //     return result;
    // }
}
// @lc code=end
