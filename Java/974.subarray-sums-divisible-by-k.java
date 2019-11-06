/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 *
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
 *
 * algorithms
 * Medium (45.96%)
 * Likes:    455
 * Dislikes: 41
 * Total Accepted:    19.2K
 * Total Submissions: 40.9K
 * Testcase Example:  '[4,5,0,-2,-3,1]\n5'
 *
 * Given an array A of integers, return the number of (contiguous, non-empty)
 * subarrays that have a sum divisible by K.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2,
 * -3]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * 
 */

// @lc code=start
class Solution {
    /* Brute Force */
    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            int curSum = 0;
            for (int j = i; j < A.length; j++) {
                curSum += A[j];
                if (curSum % K == 0) res++;
            }
        }
        return res;
    }
}
// @lc code=end
