/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (35.98%)
 * Likes:    2809
 * Dislikes: 154
 * Total Accepted:    400.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
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
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return find(s, new HashSet<>(wordDict), new HashMap<>());
    }
    
    private boolean find(String s, Set<String> dict, Map<String, Boolean> memo) {
        if (s == "" || dict.contains(s)) {
            return true;
        }
        if (memo.containsKey(s)) {  // memoized
            return memo.get(s);
        }
        
        for (int i = 1; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i)) && find(s.substring(i, s.length()), dict, memo)) {
                memo.put(s, true);  // memoize
                return true;
            }
        }
        
        memo.put(s, false);  // memoize
        return false;
    }
}
// @lc code=end
