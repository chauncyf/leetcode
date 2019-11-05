/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (44.19%)
 * Likes:    540
 * Dislikes: 182
 * Total Accepted:    122.4K
 * Total Submissions: 271.3K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int cur = carry;
            if (i >= 0) cur += num1.charAt(i) - '0';
            if (j >= 0) cur += num2.charAt(j) - '0';
            res.append(cur % 10);
            carry = cur / 10;
            i--;
            j--;
        }
    
        return res.reverse().toString();
    }
}
// @lc code=end
