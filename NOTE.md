
# String

## 5. Longest Palindromic Substring
### Problem
```text
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"
```
### Solution
Since a palindrome mirrors around its center, and there are totally `2n - 1` such centers, we could expand around these centers to find the longest palindrome. `Time complexity: O(n^2)`  

**Note**: use `//` in python for floor division.
```python
class Solution:
    def longestPalindrome(self, s: str) -> str:
        start, end = 0, 0
        for i in range(len(s)):
            cur_len = max(self.expand(s, i, i), self.expand(s, i, i + 1))
            if cur_len > end - start:
                start = i - (cur_len - 1) // 2  # trick here, remember to -1 since it could expand at center of two char
                end = i + cur_len // 2
        return s[start:end + 1]

    def expand(self, s, left, right):
        l, r = left, right
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        return r - l - 1
```
`TODO: DP, Manacher's Algorithm`

## 3. Longest Substring Without Repeating Characters
### Problem
```text
Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
```
### Solution
Basic idea, use `sliding window` to slide through the whole string.   
Used a low pointer to log where current window starts, and use a map to log where each letters appeared fot the last time.  

**Caution**: when resetting the low pointer, we should take the max of `lo` and `dic[c] + 1`.  
E.g.`abcaab`, when the window slides to the last b, low pointer is at a with index of -2 and current window is `a`, but the former b with index of 1 is still in the hashmap. If we use `dic[c] + 1` at this point, the window will become `caab` instead of `ab`.
```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        lo = 0
        dic = {}
        for i, c in enumerate(s):
            if c in dic:
                lo = max(lo, dic[c] + 1)  # caution: abcaab
            dic[c] = i
            res = max(i - lo + 1, res)
        return res
```

# Tree

## 94. Binary Tree Inorder Traversal
### Problem
```text
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]

Follow up: Recursive solution is trivial, could you do it iteratively?
```
### Solution
First start with the recursive approach.
```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        def trav(node, res):
            if node:
                trav(node.left, res)
                res.append(node.val)
                trav(node.right, res)
        res = []
        trav(root, res)
        return res
```
Since recursive solution is trivial :), let's do it iteratively!
```python
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        stack, res = [], []
        cur = root
        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            res.append(cur.val)
            cur = cur.right
        return res
```

## 144. Binary Tree Preorder Traversal
### Problem
```text
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
```
### Solution
Again, start with the trivial recursive approach.
```python
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
```
Then the iterative approach.
```python
class Solution:
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
```

## 145. Binary Tree Postorder Traversal
### Problem
```text
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

Follow up: Recursive solution is trivial, could you do it iteratively?
```
### Solution
Finally comes the postorder, let's straightforwardly go to the iterative approach.
```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        stack, res = [root], []
        while stack:
            cur = stack.pop()
            if cur:
                res.append(cur.val)            
                if cur.left:
                    stack.append(cur.left)
                if cur.right:
                    stack.append(cur.right)
        return res[::-1]  # wow, awesome :D
```

## 235. Lowest Common Ancestor of a Binary Search Tree
### Problem
```text
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
```
![tree_image](https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png)
```
Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
```
### Solution
Since it's a BST, the LCA is the split point of the two nodes, we could easily find it with this property. 
```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        cur = root
        while cur:
            if cur.val < p.val and cur.val < q.val:
                cur = cur.right
            elif cur.val > p.val and cur.val > q.val:
                cur = cur.left
            else:
                return cur
        return None
```

## 236. Lowest Common Ancestor of a Binary Tree
### Problem
```text
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
```
![tree_image](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)
```text
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 
Note:
All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
```
### Solution
Without the property of BST, we cannot easily find the LCA by a split point.  
The idea here is to use a map to point each nodes to their parent nodes.   
1. Iterate down through the root node until p and q was found, then we have all the ancestor nodes of p & q.   
2. Add all ancestors of p into a set, and finally iterate up through ancestors of q.  
Once a ancestor of q was found in the set, it is the LCA.
```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        parent = {root: None}
        stack = [root]
        # use a stack to traversal the tree and store parent nodes of each nodes in the parent dict
        while stack and (p not in parent or q not in parent):
            cur = stack.pop()
            if cur.right:
                parent[cur.right] = cur
                stack.append(cur.right)
            if cur.left:
                parent[cur.left] = cur
                stack.append(cur.left)
        ancestor = set()
        # add all ancestors of p into the ancestor set
        while p:
            ancestor.add(p)
            p = parent[p]
        # iterate through ancestors of q
        while q:
            if q in ancestor:
                return q
            q = parent[q]
        return None
```