/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (61.37%)
 * Likes:    1648
 * Dislikes: 61
 * Total Accepted:    610.3K
 * Total Submissions: 975K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * return its depth = 3.
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
    public int maxDepth(TreeNode root) {
        return trav(root, 0);   
    }
    
    private int trav(TreeNode node, int depth) {
        if (node == null) return depth;
        return Math.max(trav(node.left, depth + 1), trav(node.right, depth + 1));
    }

    // public int maxDepth(TreeNode root) {
    //     if (root == null) {
    //     return 0;
    //     } else {
    //     int left_height = maxDepth(root.left);
    //     int right_height = maxDepth(root.right);
    //     return Math.max(left_height, right_height) + 1;
    //     }
    // }
}
// @lc code=end
