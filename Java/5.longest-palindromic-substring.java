/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.58%)
 * Likes:    3896
 * Dislikes: 370
 * Total Accepted:    597.9K
 * Total Submissions: 2.2M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        int max = 0, index = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int curMax = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if (curMax > max) {
                max = curMax;
                index = i;
            }
        }
        return s.substring(index - (max - 1) / 2, index + max / 2 + 1);
    }

    private int expand(String s, int i, int j) {
        int lo = i, hi = j;
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }
        return hi - lo - 1;
    }
}
