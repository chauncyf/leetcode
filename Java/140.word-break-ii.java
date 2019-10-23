/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (27.79%)
 * Likes:    1234
 * Dislikes: 277
 * Total Accepted:    180.2K
 * Total Submissions: 631.1K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * 
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
    }


    /* No Memo, Time Limit Exceeded */
    // private List<String> res;
    // public List<String> wordBreak(String s, List<String> wordDict) {        
    //     res = new LinkedList<>();
    //     find(s, new HashSet<>(wordDict), new StringBuilder());
    //     return res;
    // }
    // private void find(String s, Set<String> dict, StringBuilder str) {
    //     if (s.equals("") || s == null) {
    //         res.add(str.toString().substring(0, str.length() - 1));
    //         return;
    //     }
    //     for (int i = 1; i <= s.length(); i++) {
    //         String subs = s.substring(0, i);
    //         if (dict.contains(subs)) {
    //             str.append(subs).append(" ");
    //             find(s.substring(i), dict, str);
    //             str.delete(str.length() - subs.length() - 1, str.length());
    //         }
    //     }
    // }
}
// @lc code=end
