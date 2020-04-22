/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
 *
 * algorithms
 * Medium (73.16%)
 * Likes:    770
 * Dislikes: 23
 * Total Accepted:    61.4K
 * Total Submissions: 80.3K
 * Testcase Example:  '[8,5,1,7,10,12]'
 *
 * Return the root node of a binary search tree that matches the given preorder
 * traversal.
 * 
 * (Recall that a binary search tree is a binary tree where for every node, any
 * descendant of node.left has a value < node.val, and any descendant of
 * node.right has a value > node.val.  Also recall that a preorder traversal
 * displays the value of the node first, then traverses node.left, then
 * traverses node.right.)
 * 
 * Example 1:
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * 
 * Note: 
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
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
    private int idx = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int upperBound) {
        if (idx >= preorder.length) return null;
        
        TreeNode cur = new TreeNode(preorder[idx++]);
        
        if (idx < preorder.length && preorder[idx] < cur.val) {
            cur.left = helper(preorder, cur.val);
        } 
        if (idx < preorder.length && preorder[idx] > cur.val && preorder[idx] < upperBound) {
            cur.right = helper(preorder, upperBound);
        }
   
        return cur;
    }
}
// @lc code=end
