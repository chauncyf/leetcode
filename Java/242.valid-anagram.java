/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (52.93%)
 * Likes:    942
 * Dislikes: 123
 * Total Accepted:    428.4K
 * Total Submissions: 790K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 * 
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] bucket = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a']++;
            bucket[t.charAt(i) - 'a']--;
        }
        for (int i : bucket) {
            if (i != 0) return false;
        }
        return true;
    }
}
// @lc code=end
