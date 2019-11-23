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
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return res;
        
        Map<String, List<List<String>>> layer = new HashMap<>();  // current layer's word -> all path to word, z -> [[a,b,z],[x,y,z]]
        List<List<String>> tmp = new ArrayList<>();
        tmp.add(new ArrayList<>(Arrays.asList(beginWord)));
        layer.put(beginWord, tmp);  // beginWord -> [[beginWord]]
        
        while (!layer.isEmpty()) {
            Map<String, List<List<String>>> nextLayer = new HashMap<>();
            for (String s : layer.keySet()) {
                if (s.equals(endWord)) {
                    for (List<String> ladder : layer.get(s)) res.add(ladder);
                } else {
                    for (int i = 0; i < s.length(); i++) {  // try to replace each char
                        for (int j = 0; j < 26; j++) {
                            String word = s.substring(0, i) + String.valueOf((char)('a' + j)) + s.substring(i + 1);
                            if (wordSet.contains(word)) {    
                                List<List<String>> ladders = nextLayer.getOrDefault(word, new ArrayList<>());
                                for (List<String> ladder : layer.get(s)) {
                                    List<String> tmpLad = new ArrayList<>(ladder);
                                    tmpLad.add(word);
                                    ladders.add(tmpLad);   
                                }
                                nextLayer.put(word, ladders);
                            }
                        }
                    }
                }
            }
            if (!res.isEmpty()) return res;
            wordSet.removeAll(nextLayer.keySet());
            layer = nextLayer;
        }
        
        return res;
    }
}

/* DFS with memo, bug */
// class Solution {
//     LinkedList<List<String>> res = new LinkedList<>();
//     Map<String, Boolean> memo = new HashMap<>();
    
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         if (!wordList.contains(endWord)) return res;
        
//         // create wildMap
//         Map<String, List<String>> wildMap = new HashMap<>();
//         for (String word : wordList) {
//             for (int i = 0; i < word.length(); i++) {
//                 String wildCard = word.substring(0, i) + "*" + word.substring(i + 1);
//                 List<String> words = wildMap.getOrDefault(wildCard, new ArrayList<>());
//                 words.add(word);
//                 wildMap.put(wildCard, words);
//             }
//         }
//         // create seenSet, avoid loop
//         Set<String> seenSet = new HashSet<>();
//         seenSet.add(beginWord);

//         helper(beginWord, endWord, wildMap, seenSet, new ArrayList<>(Arrays.asList(beginWord)));
//         if (!res.isEmpty()) {
//             while (res.peekLast().size() < res.peekFirst().size()) res.removeFirst();
//         }

//         return res;
//     }

//     private boolean helper(String beginWord, String endWord, Map<String, List<String>> wildMap, Set<String> seenSet, List<String> curLadder) {
//         if (beginWord.equals(endWord)) {
//             res.add(new ArrayList<>(curLadder));
//             return true;
//         }
//         if (!memo.getOrDefault(beginWord, true)) return false;
//         if (!res.isEmpty() && curLadder.size() >= res.get(res.size() - 1).size()) return false;
        
//         Boolean hasLadder = false;
//         for (int i = 0; i < beginWord.length(); i++) {
//             String wildCard = beginWord.substring(0, i) + "*" + beginWord.substring(i + 1);
            
//             if (wildMap.containsKey(wildCard)) {
//                 for (String s : wildMap.get(wildCard)) {
//                     if (!seenSet.contains(s)) {
//                         seenSet.add(s);
//                         curLadder.add(s);
//                         if (helper(s, endWord, wildMap, seenSet, curLadder)) {
//                             // memo.put(s, true);
//                             hasLadder = true;
//                         }
//                         // else memo.put(s, false);
//                         seenSet.remove(s);
//                         curLadder.remove(curLadder.size() - 1);
//                     }
//                 }
//             } 
//         }
//         memo.put(beginWord, hasLadder);
//         return hasLadder;
//     }

// }
// @lc code=end
