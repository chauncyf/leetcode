/*
 * @lc app=leetcode id=1002 lang=java
 *
 * [1002] Find Common Characters
 *
 * https://leetcode.com/problems/find-common-characters/description/
 *
 * algorithms
 * Easy (65.68%)
 * Likes:    456
 * Dislikes: 56
 * Total Accepted:    41.3K
 * Total Submissions: 62.8K
 * Testcase Example:  '["bella","label","roller"]'
 *
 * Given an array A of strings made only from lowercase letters, return a list
 * of all characters that show up in all strings within the list (including
 * duplicates).  For example, if a character occurs 3 times in all strings but
 * not 4 times, you need to include that character three times in the final
 * answer.
 * 
 * You may return the answer in any order.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] map = new int[26];
        Arrays.fill(map, Integer.MAX_VALUE);
        for (String s : A) {
            int[] tmpMap = new int[26];
            for (char c : s.toCharArray()) {
                tmpMap[c - 'a']++;
            }
            for (int i = 0; i < map.length; i++) {
                map[i] = Math.min(map[i], tmpMap[i]);
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i]; j++) {
                res.add(Character.toString((char) ('a' + i)));
            }
        }
        return res;
    }

    // public List<String> commonChars(String[] A) {
    //     List<String> res = new ArrayList<>();
    //     if (A.length == 0) return res;
        
    //     Map<Character, Integer> map = new HashMap<>();
    //     for (char c : A[0].toCharArray()) {
    //         map.put(c, map.getOrDefault(c, 0) + 1);
    //     }
    //     for (int i = 1; i < A.length; i++) {
    //         Map<Character, Integer> tmp = new HashMap<>();
    //         for (char c : A[i].toCharArray()) {
    //             tmp.put(c, tmp.getOrDefault(c, 0) + 1);
    //         }
    //         for (char c : map.keySet()) {
    //             map.put(c, Math.min(map.get(c), tmp.getOrDefault(c, 0)));
    //         }
    //     }
        
    //     for (char c : map.keySet()) {
    //         for (int i = 0; i < map.get(c); i++) {
    //             res.add(Character.toString(c));
    //         }
    //     }
        
    //     return res;
    // }
}
// @lc code=end
