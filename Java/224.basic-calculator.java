/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 *
 * https://leetcode.com/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (33.37%)
 * Likes:    1035
 * Dislikes: 106
 * Total Accepted:    132.3K
 * Total Submissions: 380.5K
 * Testcase Example:  '"1 + 1"'
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces  .
 * 
 * Example 1:
 * 
 * 
 * Input: "1 + 1"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: " 2-1 + 2 "
 * Output: 3
 * 
 * Example 3:
 * 
 * 
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * 
 * 
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        int res = 0;
        int cur = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                cur = cur * 10 + c - '0';
            } else if (c == '+' || c == '-') {
                res += cur * sign;
                cur = 0;
                sign = c == '+' ? 1 : -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                // cur = 0;  // cur already marked as 0 before (
                sign = 1;
            } else if (c == ')') {
                res += cur * sign;
                res = res * stack.pop() + stack.pop();
                cur = 0;
                // sign = 1;  // next char will be sign
            }
        }
        if (cur != 0) res += cur * sign;
        return res;
    }
}
// @lc code=end
