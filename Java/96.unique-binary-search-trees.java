/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (47.03%)
 * Likes:    2242
 * Dislikes: 86
 * Total Accepted:    232.1K
 * Total Submissions: 478.5K
 * Testcase Example:  '3'
 *
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n?
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */

// @lc code=start
class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        if (memo.containsKey(n)) return memo.get(n);
        
        int sum = 0;
        for (int i = 0; i < n; i++) {  // i = num of node in right tree, node in left tree = n - i - 1 (root)
            sum += numTrees(i) * numTrees(n - i - 1);  // num of trees = uniq right * uniq left
        }
        
        memo.put(n, sum);
        return sum;
    }
}
// @lc code=end
