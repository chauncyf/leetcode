/*
 * @lc app=leetcode id=784 lang=java
 *
 * [784] Letter Case Permutation
 *
 * https://leetcode.com/problems/letter-case-permutation/description/
 *
 * algorithms
 * Easy (57.95%)
 * Likes:    792
 * Dislikes: 92
 * Total Accepted:    60.4K
 * Total Submissions: 101.3K
 * Testcase Example:  '"a1b2"'
 *
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string.  Return a list of all possible
 * strings we could create.
 * 
 * 
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * 
 * Input: S = "12345"
 * Output: ["12345"]
 * 
 * 
 * Note:
 * 
 * 
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), new char[S.length()], res, 0);
        return res;
    }
    
    private void helper(char[] chars, char[] subset, List<String> res, int i) {
        if (i == chars.length) {
            StringBuilder s = new StringBuilder();
            for (char c : subset) {
                s.append(c);
            }
            res.add(s.toString());
            return;
        }
        if (Character.isLetter(chars[i])) {
            subset[i] = Character.toLowerCase(chars[i]);
            helper(chars, subset, res, i + 1);
            subset[i] = Character.toUpperCase(chars[i]);
            helper(chars, subset, res, i + 1);
        }
        else {
            subset[i] = chars[i];
            helper(chars, subset, res, i + 1);
        }
    }
}
// @lc code=end
