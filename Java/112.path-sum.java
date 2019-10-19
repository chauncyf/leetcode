/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
 *
 * https://leetcode.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (38.28%)
 * Likes:    1177
 * Dislikes: 376
 * Total Accepted:    362.1K
 * Total Submissions: 930.5K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
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
 * ⁠/  \      \
 * 7    2      1
 * 
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;  // cannot use root == null to evaluate if it's a leaf, e.g. [1, 2] 1
        if (sum - root.val == 0 && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    // public boolean hasPathSum(TreeNode root, int sum) {
    //     if (root == null) return false;

    //     Map<TreeNode, Integer> map = new HashMap<>();
    //     Queue<TreeNode> queue = new LinkedList<>();
        
    //     map.put(root, 0);
    //     queue.offer(root);
    //     while (!queue.isEmpty()) {
    //         TreeNode cur = queue.poll();
    //         int curSum = cur.val + map.get(cur);
    //         if (curSum == sum && cur.right == null && cur.left == null) {
    //             return true;
    //         } 
    //         if (cur.left != null) {
    //             queue.offer(cur.left);
    //             map.put(cur.left, curSum);
    //         } 
    //         if (cur.right != null) {
    //             queue.offer(cur.right);
    //             map.put(cur.right, curSum);
    //         }
    //     }

    //     return false;   
    // }
}
// @lc code=end
