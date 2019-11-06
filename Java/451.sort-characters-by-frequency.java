/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (56.73%)
 * Likes:    868
 * Dislikes: 80
 * Total Accepted:    112.7K
 * Total Submissions: 195.5K
 * Testcase Example:  '"tree"'
 *
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input:
 * "tree"
 * 
 * Output:
 * "eert"
 * 
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * "cccaaa"
 * 
 * Output:
 * "cccaaa"
 * 
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input:
 * "Aabb"
 * 
 * Output:
 * "bbAa"
 * 
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // List<List<Character>> bucket = new ArrayList<>(s.length() + 1);
        List<Character>[] bucket = new List[s.length() + 1];
        for (Character c : map.keySet()) {
            int count = map.get(c);
            // if (bucket.get(count) == null) {
            //     bucket.add(count, new ArrayList<>());
            // }
            // bucket.get(count).add(c);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(c);
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = s.length(); i >= 0; i--) {
            // if (bucket.get(i) != null) {
            //     for (Character c : bucket.get(i)) {
            //         res.append(c);
            //     }
            // }
            if (bucket[i] != null) {
                for (Character c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        res.append(c);                    
                    }
                }
            }
        }
        
        return res.toString();
    }
}
// @lc code=end
