/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (49.17%)
 * Likes:    1582
 * Dislikes: 43
 * Total Accepted:    398.7K
 * Total Submissions: 810.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = q.remove();
                curLevel.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(curLevel);
        }
        
        return res;
    }

    
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     helper(root, 0, res);
    //     return res;
    // }
    
    // private void helper(TreeNode node, int level, List<List<Integer>> levels) {
    //     if (node == null) return;
    //     if (level >= levels.size()) levels.add(new ArrayList<>());
    //     levels.get(level).add(node.val);
    //     helper(node.left, level + 1, levels);
    //     helper(node.right, level + 1, levels);
    // }
}
