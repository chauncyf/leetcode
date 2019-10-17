/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (38.52%)
 * Likes:    2447
 * Dislikes: 145
 * Total Accepted:    336.3K
 * Total Submissions: 836.5K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given
 * nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null) return root;
        
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        
        parentMap.put(root, null);
        stack.push(root);
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode cur = stack.pop();
            
            if (cur.right != null) {
                parentMap.put(cur.right, cur);
                stack.push(cur.right);
            }
            if (cur.left != null) {
                parentMap.put(cur.left, cur);
                stack.push(cur.left);
            }
        }
        
        Set<TreeNode> ances = new HashSet<>();
        TreeNode anc = p;
        while (anc != null) {
            ances.add(anc);
            anc = parentMap.get(anc);
        }
        
        anc = q;
        while (!ances.contains(anc)) {
            anc = parentMap.get(anc);
        }
        return anc;
    }
}
// @lc code=end

