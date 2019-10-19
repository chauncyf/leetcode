/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (41.50%)
 * Likes:    1120
 * Dislikes: 41
 * Total Accepted:    263.3K
 * Total Submissions: 618.1K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
    }

    // private List<List<Integer>> res;
        
    // public List<List<Integer>> pathSum(TreeNode root, int sum) {
    //     res = new ArrayList<>();
    //     helper(root, sum, new ArrayList<Integer>());
    //     return res;
    // }
    
    // private void helper(TreeNode node, int sum, List<Integer> path) {
    //     if (node == null) return;
            
    //     path.add(node.val);
            
    //     if (node.left == null && node.right == null) {
    //         if (node.val - sum == 0) res.add(new ArrayList<>(path));
    //         return;   
    //     }
        
    //     if (node.left != null) { 
    //         helper(node.left, sum - node.val, path);
    //         path.remove(path.size() - 1);
    //     }
    //     if (node.right != null) {
    //         helper(node.right, sum - node.val, path);
    //         path.remove(path.size() - 1);
    //     }        
    // }
}
// @lc code=end
