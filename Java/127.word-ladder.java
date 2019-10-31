/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (24.83%)
 * Likes:    1935
 * Dislikes: 923
 * Total Accepted:    313K
 * Total Submissions: 1.2M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> wildDict = new HashMap<>();
        Map<String, Integer> discoverMap = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        // construct wildcard dict
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String w = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> list = wildDict.getOrDefault(w, new ArrayList<>());
                list.add(word);
                wildDict.put(w, list);
            }
        }
        
        // bfs
        discoverMap.put(beginWord, 1);
        q.offer(beginWord);
        while (!q.isEmpty()) {
            String word = q.poll();
            for (int i = 0; i < word.length(); i++) {
                
                // find all adjacent words
                String wildWord = word.substring(0, i) + "*" + word.substring(i + 1);
                if (wildDict.containsKey(wildWord)) {
                    for (String adjWord : wildDict.get(wildWord)) {
                        int level = discoverMap.get(word) + 1;
                        if (adjWord.equals(endWord)) {
                            return level;
                        }
                        
                        // if not discovered yet, add to discover map
                        if (!discoverMap.containsKey(adjWord)) {
                            discoverMap.put(adjWord, level);
                            q.offer(adjWord);
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}
// @lc code=end
