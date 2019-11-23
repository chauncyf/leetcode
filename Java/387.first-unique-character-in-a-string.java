/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (50.39%)
 * Likes:    1292
 * Dislikes: 90
 * Total Accepted:    348.3K
 * Total Submissions: 683.1K
 * Testcase Example:  '"leetcode"'
 *
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] bucket = new int[26];
        for (char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (bucket[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
// @lc code=end
