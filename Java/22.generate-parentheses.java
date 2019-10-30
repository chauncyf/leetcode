/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (56.06%)
 * Likes:    3473
 * Dislikes: 206
 * Total Accepted:    411.2K
 * Total Submissions: 712.5K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, n, 0, new StringBuilder());
        return res;
    }
    
    private void helper(List<String> list, int r, int l, StringBuilder str) {
        if (r == 0 && l == 0) {
            list.add(str.toString());
            return;
        }
        if (r > 0) {
            helper(list, r - 1, l + 1, str.append("("));
            str.deleteCharAt(str.length() - 1);
        }
        if (l > 0) {
            helper(list, r, l - 1, str.append(")"));
            str.deleteCharAt(str.length() - 1);
        }
    }
}
// @lc code=end
