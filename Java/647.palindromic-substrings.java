/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (57.53%)
 * Likes:    1700
 * Dislikes: 86
 * Total Accepted:    125.7K
 * Total Submissions: 215.9K
 * Testcase Example:  '"abc"'
 *
 * Given a string, your task is to count how many palindromic substrings in
 * this string.
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters.
 * 
 * Example 1:
 * 
 * 
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The input string length won't exceed 1000.
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += extend(i, i, s);
            res += extend(i, i + 1, s);                        
        }
        return res;
    }
    
    private int extend(int i, int j, String s) {
        int sub = 0;
        while (i >= 0 & j < s.length() && s.charAt(i) == s.charAt(j)) {
            sub++;
            i--;
            j++;            
        }
        return sub;
    }
}
// @lc code=end
