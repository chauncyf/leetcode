/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 *
 * https://leetcode.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (18.30%)
 * Likes:    1253
 * Dislikes: 213
 * Total Accepted:    141K
 * Total Submissions: 734.6K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such
 * that:
 * 
 * 
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return an empty list if there is no such transformation sequence.
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
 * Output:
 * [
 * ⁠ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
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
 * Output: []
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 */

// @lc code=start
class Solution {
    /* BFS with Q */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return res;

        Map<String, List<String>> wordMap = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String wildCard = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> list = wordMap.getOrDefault(wildCard, new ArrayList<>());
                list.add(word);
                wordMap.put(wildCard, list);
            }
        }
        
        Queue<List<String>> q = new LinkedList<>();
        q.offer(new ArrayList<>(Arrays.asList(beginWord)));
        
        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> curWords = new HashSet<>();  // words discovered this layer
            
            for (int x = 0; x < size; x++) {
                List<String> curLadder = q.poll();
                String lastWord = curLadder.get(curLadder.size() - 1);
                if (lastWord.equals(endWord)) {
                    res.add(curLadder);
                } else {
                    for (int i = 0; i < lastWord.length(); i++) {
                        String wildCard = lastWord.substring(0, i) + "*" + lastWord.substring(i + 1);
                        if (wordMap.containsKey(wildCard)) {
                            for (String curWord : wordMap.get(wildCard)) {
                                if (wordSet.contains(curWord)) {
                                    List<String> newLadder = new ArrayList<>(curLadder);
                                    newLadder.add(curWord);
                                    q.offer(newLadder);
                                    curWords.add(curWord);
                                }
                            }
                        }
                    }
                }
            }
            
            if (!res.isEmpty()) return res;
            wordSet.removeAll(curWords);
        }
        
        return res;
    }

    /* BFS with Map */
    // public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    //     List<List<String>> res = new ArrayList<>();
    //     Set<String> wordSet = new HashSet<>(wordList);
    //     if (!wordSet.contains(endWord)) return res;
        
    //     Map<String, List<List<String>>> layer = new HashMap<>();  // current layer's word -> all path to word, z -> [[a,b,z],[x,y,z]]
    //     List<List<String>> tmp = new ArrayList<>();
    //     tmp.add(new ArrayList<>(Arrays.asList(beginWord)));
    //     layer.put(beginWord, tmp);  // beginWord -> [[beginWord]]
        
    //     while (!layer.isEmpty()) {
    //         Map<String, List<List<String>>> nextLayer = new HashMap<>();
    //         for (String s : layer.keySet()) {
    //             if (s.equals(endWord)) {
    //                 for (List<String> ladder : layer.get(s)) res.add(ladder);
    //             } else {
    //                char[] chars = s.toCharArray();  // toCharArray and avoid string concatenation
    //                 for (int i = 0; i < s.length(); i++) {  // try to replace each char
    //                     char org = chars[i];
    //                     for (char c = 'a'; c <= 'z'; c++) {
    //                         chars[i] = c;
    //                         String word = new String(chars);
    //                         if (wordSet.contains(word)) {    
    //                             List<List<String>> ladders = nextLayer.getOrDefault(word, new ArrayList<>());
    //                             for (List<String> ladder : layer.get(s)) {
    //                                 List<String> tmpLad = new ArrayList<>(ladder);
    //                                 tmpLad.add(word);
    //                                 ladders.add(tmpLad);   
    //                             }
    //                             nextLayer.put(word, ladders);
    //                         }
    //                     }
    //                     chars[i] = org;
    //                 }
    //             }
    //         }
    //         if (!res.isEmpty()) return res;
    //         wordSet.removeAll(nextLayer.keySet());
    //         layer = nextLayer;
    //     }
        
    //     return res;
    // }
}
// @lc code=end
