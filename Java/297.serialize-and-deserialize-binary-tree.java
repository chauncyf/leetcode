/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (41.83%)
 * Likes:    2150
 * Dislikes: 106
 * Total Accepted:    240.9K
 * Total Submissions: 549.9K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Example: 
 * 
 * 
 * You may serialize the following tree:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 * 
 * as "[1,2,3,null,null,4,5]"
 * 
 * 
 * Clarification: The above format is the same as how LeetCode serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself.
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        seHelper(root, res);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private void seHelper(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("null,");
            return;
        }
        res.append(root.val).append(",");
        seHelper(root.left, res);
        seHelper(root.right, res);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {        
        List<String> nodes = Arrays.asList(data.split(","));
        Iterator<String> iter = nodes.iterator();         
        return desHelper(iter);
    }
    
    private TreeNode desHelper(Iterator<String> iter) {        
        String cur = iter.next();
        if (cur.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(cur));
        node.left = desHelper(iter);
        node.right = desHelper(iter);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end


/* Just not.even.fair :) */

// class Codec:
//     def serialize(self, root):
//         def doit(node):
//             if node:
//                 vals.append(str(node.val))
//                 doit(node.left)
//                 doit(node.right)
//             else:
//                 vals.append('#')
//         vals = []
//         doit(root)
//         return ' '.join(vals)

//     def deserialize(self, data):
//         def doit():
//             val = next(vals)
//             if val == '#':
//                 return None
//             node = TreeNode(int(val))
//             node.left = doit()
//             node.right = doit()
//             return node
//         vals = iter(data.split())
//         return doit()
