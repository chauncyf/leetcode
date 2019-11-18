/*
 * @lc app=leetcode id=250 lang=java
 *
 * [250] Count Univalue Subtrees
 *
 * https://leetcode.com/problems/count-univalue-subtrees/
 *
 * Given a binary tree, count the number of uni-value subtrees.
 * 
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * 
 * 
 * Example :
 * 
 * Input:  root = [5,1,5,5,5,null,5]
 * 
 *          5
 *         / \
 *        1   5
 *       / \   \
 *      5   5   5
 * 
 * Output: 4
 * 
 */

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
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        return (isUniTree(root) ? 1 : 0) + countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
    }
    
    public boolean isUniTree(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.val != root.left.val) return false;
        if (root.right != null && root.val != root.right.val) return false;
        return isUniTree(root.left) && isUniTree(root.right);
    }
}
