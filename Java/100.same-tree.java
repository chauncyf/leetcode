/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
 *
 * https://leetcode.com/problems/same-tree/description/
 *
 * algorithms
 * Easy (50.41%)
 * Likes:    1432
 * Dislikes: 46
 * Total Accepted:    443.5K
 * Total Submissions: 866.5K
 * Testcase Example:  '[1,2,3]\n[1,2,3]'
 *
 * Given two binary trees, write a function to check if they are the same or
 * not.
 * 
 * Two binary trees are considered the same if they are structurally identical
 * and the nodes have the same value.
 * 
 * Example 1:
 * 
 * 
 * Input:     1         1
 * ⁠         / \       / \
 * ⁠        2   3     2   3
 * 
 * ⁠       [1,2,3],   [1,2,3]
 * 
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:     1         1
 * ⁠         /           \
 * ⁠        2             2
 * 
 * ⁠       [1,2],     [1,null,2]
 * 
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:     1         1
 * ⁠         / \       / \
 * ⁠        2   1     1   2
 * 
 * ⁠       [1,2,1],   [1,1,2]
 * 
 * Output: false
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if (p == null && q == null) return true;
    //     if (p == null || q == null) return false;
        
    //     Queue<TreeNode> q1 = new LinkedList<>();
    //     Queue<TreeNode> q2 = new LinkedList<>();
    //     q1.offer(p);
    //     q2.offer(q);
    //     while (!q1.isEmpty()) {
    //         TreeNode cur1 = q1.poll();
    //         TreeNode cur2 = q2.poll();
    //         if (cur1.val != cur2.val) return false;
    //         if (cur1.left != null || cur2.left != null) {
    //             if (cur1.left != null && cur2.left != null) {
    //                 q1.offer(cur1.left);
    //                 q2.offer(cur2.left);
    //             } else {
    //                 return false;
    //             }
    //         }
    //         if (cur1.right != null || cur2.right != null) {
    //             if (cur1.right != null && cur2.right != null) {
    //                 q1.offer(cur1.right);
    //                 q2.offer(cur2.right);
    //             } else {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
}
// @lc code=end
