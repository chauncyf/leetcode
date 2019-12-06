/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 *
 * https://leetcode.com/problems/counting-bits/description/
 *
 * algorithms
 * Medium (65.26%)
 * Likes:    1767
 * Dislikes: 122
 * Total Accepted:    202.8K
 * Total Submissions: 306.9K
 * Testcase Example:  '2'
 *
 * Given a non negative integer number num. For every numbers i in the range 0
 * ≤ i ≤ num calculate the number of 1's in their binary representation and
 * return them as an array.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: [0,1,1]
 * 
 * Example 2:
 * 
 * 
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * 
 * 
 * Follow up:
 * 
 * 
 * It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a
 * single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like
 * __builtin_popcount in c++ or in any other language.
 * 
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        int pow = 1;
        for(int i = 1, t = 0; i <= num; i++, t++) {
            if(i == pow) {
                pow *= 2;
                t = 0;
            }
            res[i] = res[t] + 1;
        }
        return res;
    }

    // public int[] countBits(int num) {
    //     int[] res = new int[num + 1];
    //     for (int i = 0; i <= num; i++) {
    //         res[i] = getBits(i);
    //     }
    //     return res;
    // }
    
    // public int getBits(int num) {
    //     int count = 0;
    //     while (num > 0) {
    //         if (num % 2 != 0) count++;
    //         num /= 2;
    //     }
    //     return count;
    // }
}
// @lc code=end
