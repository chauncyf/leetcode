/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (30.48%)
 * Likes:    2192
 * Dislikes: 173
 * Total Accepted:    240.9K
 * Total Submissions: 765.6K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the
 * root.
 * 
 * Example 1:
 * 
 * Input: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * Output: 6
 * 
 * 
 * Example 2:
 * 
 * Input: [-10,9,20,null,null,15,7]
 * 
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 
 * Output: 42
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
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }
    
    private int maxGain(TreeNode node) {
        if (node == null) return 0;
        int maxLeft = Math.max(maxGain(node.left), 0);
        int maxRight = Math.max(maxGain(node.right), 0);
        max = Math.max(max, node.val + maxLeft + maxRight);
        return node.val + Math.max(maxLeft, maxRight);
    }
}
// @lc code=end
