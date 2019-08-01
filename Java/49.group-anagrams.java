/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (48.14%)
 * Likes:    1837
 * Dislikes: 118
 * Total Accepted:    367.8K
 * Total Submissions: 764K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = Arrays.toString(charArray);
            List<String> ana;
            if (map.containsKey(sorted)) {
                ana = map.get(sorted);
            } else {
                ana = new ArrayList<>();
            }
            ana.add(s);
            map.put(sorted, ana);
        }
        for (String s: map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }
}

