"""
144. Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]

Follow up: Recursive solution is trivial, could you do it iteratively?
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        def trav(node, res):
            if node:
                res.append(node.val)
                trav(node.left, res)
                trav(node.right, res)

        res = []
        trav(root, res)
        return res

    def preorderTraversal(self, root: TreeNode) -> List[int]:
        stack, res = [root], []
        while stack:
            cur = stack.pop()
            if cur:
                res.append(cur.val)
                if cur.right:
                    stack.append(cur.right)
                if cur.left:
                    stack.append(cur.left)
        return res
