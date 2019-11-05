/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 *
 * https://leetcode.com/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (48.39%)
 * Likes:    639
 * Dislikes: 66
 * Total Accepted:    112.7K
 * Total Submissions: 230.5K
 * Testcase Example:  '"abccccdd"'
 *
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome
 * here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * 
 * Example: 
 * 
 * Input:
 * "abccccdd"
 * 
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int res = 0, odd = 0;
        for (char c : map.keySet()) {
            // if (map.get(c) % 2 == 0) res+= map.get(c);
            // else if (map.get(c) > odd) odd = map.get(c);
            res += map.get(c) / 2 * 2;
        }
        
        return (res == s.length()) ? res : res + 1;
    }
}
// @lc code=end
