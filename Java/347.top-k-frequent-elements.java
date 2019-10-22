/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (55.82%)
 * Likes:    1938
 * Dislikes: 123
 * Total Accepted:    258.7K
 * Total Submissions: 453.2K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Note: 
 * 
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 * 
 */

// @lc code=start
class Solution {
    // Bucket Sort Solution
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (int i : map.keySet()) {
            int freq = map.get(i);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<Integer>();
            bucket[freq].add(i);
        }
        
        List<Integer> res = new LinkedList<>();
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                for (int j : bucket[i]) {
                    if (res.size() < k) {
                        res.add(j);
                    }
                } 
            }
        }
        
        return res;
    }

    // PQ Solution

    // public List<Integer> topKFrequent(int[] nums, int k) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int i : nums) {
    //         map.put(i, map.getOrDefault(i, 0) + 1);
    //     }
        
    //     PriorityQueue<Integer> pq = new PriorityQueue<>(k, (n1, n2) -> map.get(n1) - map.get(n2));
    //     for (int i : map.keySet()) {
    //         pq.offer(i);
    //         if (pq.size() > k) pq.poll();
    //     }
        
    //     List<Integer> res = new ArrayList<>();
    //     while (!pq.isEmpty()) {
    //         res.add(pq.poll());
    //     }
        
    //     Collections.reverse(res);
    
    //     return res;
    // }
}
// @lc code=end

