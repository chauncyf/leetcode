/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 *
 * https://leetcode.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (36.94%)
 * Likes:    1394
 * Dislikes: 84
 * Total Accepted:    133.9K
 * Total Submissions: 343.9K
 * Testcase Example:  '10'
 *
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
 * 5. 
 * 
 * Example:
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * 
 * Note:  
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */

// @lc code=start
class Solution {
    /* Merge three subsequences that consist of ugly-sequence itself (1, 2, 3, 5, … ) multipy with 2, 3, 5 */
    public int nthUglyNumber(int n) {        
        int[] ugly = new int[n];
        ugly[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int num2 = 2, num3 = 3, num5 = 5;
        
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(num2, num3), num5);
            ugly[i] = min;
            if (min == num2) {
                num2 = ugly[++idx2] * 2;
            }
            if (min == num3) {
                num3 = ugly[++idx3] * 3;
            } 
            if (min == num5) {
                num5 = ugly[++idx5] * 5;
            }
        }
        
        return ugly[n - 1];
    }
}
// @lc code=end
