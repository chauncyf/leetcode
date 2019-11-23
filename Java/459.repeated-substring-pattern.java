/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 *
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 *
 * algorithms
 * Easy (40.23%)
 * Likes:    956
 * Dislikes: 108
 * Total Accepted:    92.9K
 * Total Submissions: 228.1K
 * Testcase Example:  '"abab"'
 *
 * Given a non-empty string check if it can be constructed by taking a
 * substring of it and appending multiple copies of the substring together. You
 * may assume the given string consists of lowercase English letters only and
 * its length will not exceed 10000.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "aba"
 * Output: False
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring
 * "abcabc" twice.)
 * 
 * 
 */

// @lc code=start
class Solution {
    /*
        return str in (2 * str)[1:-1]

        The maximum length of a "repeated" substring that you could get from a string would be half it's length
        For example, s = "abcdabcd", "abcd" of len = 4, is the repeated substring.
        You cannot have a substring >(len(s)/2), that can be repeated.

        So, when ss = s + s , we will have atleast 4 parts of "repeated substring" in ss.
        (s+s)[1:-1], With this we are removing 1st char and last char => Out of 4 parts of repeated substring, 2 part will be gone (they will no longer have the same substring).
        ss.find(s) != -1, But still we have 2 parts out of which we can make s. And that's how ss should have s, if s has repeated substring.
     */
    // public boolean repeatedSubstringPattern(String s) {
    //     String str = s + s;
    //     return str.substring(1, str.length() - 1).contains(s);
    // }

    public boolean repeatedSubstringPattern(String s) {
        for (int i = s.length() / 2; i >= 1; i--) {  // substring's length cannot longer than half of s'length
            if (s.length() % i == 0) {  // only consider cases when substring's length is a divisor of s
                String subs = s.substring(0, i);
                int m = s.length() / i;

                int j = 1;
                while (j < m) {  // s should be s.len / i times of subs
                    if (!s.substring(i * j, i + i * j).equals(subs)) break;  // check (i, 2i) (2i, 3i) ..
                    j++;
                }
                if (j == m) return true;

                // StringBuilder str = new StringBuilder();
                // for (int j = 0; j < m; j++) {
                //     str.append(subs);
                // }
                // if (s.equals(str.toString())) return true;
            }
        }
        return false;
    }
}
// @lc code=end
