/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (42.33%)
 * Likes:    2390
 * Dislikes: 319
 * Total Accepted:    418.6K
 * Total Submissions: 988.9K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */

// @lc code=start
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        helper(digits, map, 0, new StringBuilder());
        return res;
    }
    
    private void helper(String digits, Map<Character, String> map, int idx, StringBuilder str) {
        if (idx == digits.length()) {
            res.add(str.toString());
            return;
        }
        
        char digit = digits.charAt(idx);
        for (char c : map.get(digit).toCharArray()) {
            str.append(c);
            helper(digits, map, idx + 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
// @lc code=end
