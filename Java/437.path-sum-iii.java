/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (43.31%)
 * Likes:    2346
 * Dislikes: 148
 * Total Accepted:    132.3K
 * Total Submissions: 299.7K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards
 * (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * 
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
    /* Prefix Sum */
    private int res = 0;
    
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();  // sum -> freq
        prefixSumMap.put(0, 1);
        helper(root, sum, 0, prefixSumMap);
        return res;
    }
    
    private void helper(TreeNode node, int sum, int curSum, Map<Integer, Integer> preSum) {
        if (node == null) return;
        
        curSum += node.val;
        if (preSum.containsKey(curSum - sum)) {  // curSum - preSum = sum -> looking for preSum in Map
            res += preSum.get(curSum - sum);
        }
        
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        helper(node.left, sum, curSum, preSum);
        helper(node.right, sum, curSum, preSum);
        preSum.put(curSum, preSum.get(curSum) - 1);
    }

    /* Recursive */
    // private int res = 0;

    // public int pathSum(TreeNode root, int sum) {
    //     if (root == null) return 0;
    //     helper(root, sum);
    //     pathSum(root.left, sum);
    //     pathSum(root.right, sum);
    //     return res;
    // }
    
    // private void helper(TreeNode node, int sum) {
    //     if (node == null) return;
    //     if (sum - node.val == 0) res++;
    //     helper(node.left, sum - node.val);
    //     helper(node.right, sum - node.val);
    // }
}
// @lc code=end
