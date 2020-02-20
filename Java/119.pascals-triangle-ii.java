/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (44.53%)
 * Likes:    637
 * Dislikes: 188
 * Total Accepted:    250.9K
 * Total Submissions: 534.7K
 * Testcase Example:  '3'
 *
 * Given a non-negative index k where k ≤ 33, return the k^th index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: [1,3,3,1]
 * 
 * 
 * Follow up:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        
        for (int r = 1; r <= rowIndex; r++) {
            res.add(1);
            for (int i = res.size() - 2; i > 0 ; i--) {
                res.set(i, res.get(i) + res.get(i - 1));
            }  
        }
        
        return res;
    }


    // public List<Integer> getRow(int rowIndex) {
    //     List<Integer> res = new ArrayList<>();
    //     res.add(1);
    //     return helper(rowIndex, res);
    // }
    
    // private List<Integer> helper(int idx, List<Integer> res) {
    //     if (idx == 0) {
    //         return res;
    //     }
    //     res.add(1);
    //     for (int i = res.size() - 2; i > 0 ; i--) {
    //         res.set(i, res.get(i) + res.get(i - 1));
    //     }            
    //     return helper(idx - 1, res);
    // }
}
// @lc code=end
