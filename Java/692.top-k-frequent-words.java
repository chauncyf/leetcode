/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 *
 * https://leetcode.com/problems/top-k-frequent-words/description/
 *
 * algorithms
 * Medium (46.41%)
 * Likes:    979
 * Dislikes: 95
 * Total Accepted:    90.8K
 * Total Submissions: 191.2K
 * Testcase Example:  '["i", "love", "leetcode", "i", "love", "coding"]\n2'
 *
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two
 * words have the same frequency, then the word with the lower alphabetical
 * order comes first.
 * 
 * Example 1:
 * 
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * ⁠   Note that "i" comes before "love" due to a lower alphabetical order.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is",
 * "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent
 * words,
 * ⁠   with the number of occurrence being 4, 3, 2 and 1 respectively.
 * 
 * 
 * 
 * Note:
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * 
 * 
 * 
 * Follow up:
 * 
 * Try to solve it in O(n log k) time and O(n) extra space.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        
        // PriorityQueue<String> minQ = new PriorityQueue<>(new Comparator<String>(){
        //     @Override
        //     public int compare(String a, String b)
        //     {
        //         if (freqMap.get(a).equals(freqMap.get(b))) {
        //             return b.compareTo(a);
        //         } else {
        //             return freqMap.get(a) - freqMap.get(b);
        //         }
        //     }
        // });

        // word using reversed natural order, freq using ascending order
        PriorityQueue<String> minQ = new PriorityQueue<>((a, b) -> freqMap.get(a).equals(freqMap.get(b)) ? b.compareTo(a) : freqMap.get(a) - freqMap.get(b));
        for (String word : freqMap.keySet()) {
            // minQ.offer(word);
            // if (minQ.size() > k) minQ.poll();
            
            if (minQ.size() < k) {
                minQ.offer(word);
            } else {
                // word with same freq still need to compare lexical order
                if (freqMap.get(word) >= freqMap.get(minQ.peek())) {
                    minQ.offer(word);
                    minQ.poll();
                }
            }
        }
        
        // use linked list to get element in descending order
        LinkedList<String> res = new LinkedList<>();
        while (!minQ.isEmpty()) {
            res.addFirst(minQ.poll());
        }
        
        return res;
    }
}
// @lc code=end
