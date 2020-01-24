/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
 *
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (41.94%)
 * Likes:    1543
 * Dislikes: 67
 * Total Accepted:    141.2K
 * Total Submissions: 329.6K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * 
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 * 
 * 
 * Example 1:
 * 
 * Given tree s:
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * 
 * Given tree t:
 * 
 * ⁠  4 
 * ⁠ / \
 * ⁠1   2
 * 
 * Return true, because t has the same structure and node values with a subtree
 * of s.
 * 
 * 
 * Example 2:
 * 
 * Given tree s:
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 * 
 * Given tree t:
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 * 
 * Return false.
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
    // public boolean isSubtree(TreeNode s, TreeNode t) {
    //     if (s == null && t == null) return true;
    //     if (s == null || t == null) return false;
        
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.offer(s);
    //     while (!q.isEmpty()) {
    //         TreeNode cur = q.poll();
    //         if (cur.val == t.val && isSameTree(cur, t)) return true; 
    //         if (cur.left != null) q.offer(cur.left);
    //         if (cur.right != null) q.offer(cur.right);
    //     }
        
    //     return false;
    // }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    } 

    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
// @lc code=end
