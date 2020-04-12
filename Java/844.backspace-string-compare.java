/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 *
 * https://leetcode.com/problems/backspace-string-compare/description/
 *
 * algorithms
 * Easy (46.47%)
 * Likes:    1313
 * Dislikes: 65
 * Total Accepted:    149.3K
 * Total Submissions: 315.8K
 * Testcase Example:  '"ab#c"\n"ad#c"'
 *
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * 
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * 
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * 
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * 
 * Note:
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * 
 * Follow up:
 * Can you solve it in O(N) time and O(1) space?
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (i >= 0 || j >= 0) {
            int back = 0;
            while (i >= 0 && (S.charAt(i) == '#' || back > 0)) {
                back += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            
            back = 0;
            while (j >= 0 && (T.charAt(j) == '#' || back > 0)) {
                back += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
 
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i == -1 && j == -1;
    }
}
// @lc code=end
