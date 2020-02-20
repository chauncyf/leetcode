/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 *
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 *
 * algorithms
 * Medium (55.08%)
 * Likes:    467
 * Dislikes: 93
 * Total Accepted:    57.5K
 * Total Submissions: 102.8K
 * Testcase Example:  '[5,2,-3]'
 *
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order.
 * 
 * 
 * Examples 1
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -3
 * 
 * return [2, -3, 4], since all the values happen only once, return all of them
 * in any order.
 * 
 * 
 * Examples 2
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -5
 * 
 * return [2], since 2 happens twice, however -5 only occur once.
 * 
 * 
 * Note:
 * You may assume the sum of values in any subtree is in the range of 32-bit
 * signed integer.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};
        
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        
        List<Integer> res = new ArrayList<>();
        Integer freq = null;
        for (Integer i : map.keySet()) {
            int f = map.get(i);
            if (freq == null || f > freq) {
                freq = f;
                res.clear();
                res.add(i);
            }
            else if (f == freq){
                res.add(i);
            }
            
        }
        
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        
        return ans;
    }
   
    private int helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        
        int left = helper(root.left, map);
        int right = helper(root.right, map);        
        int sum = root.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        return sum;
    }
}
// @lc code=end
