/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (41.40%)
 * Likes:    1622
 * Dislikes: 57
 * Total Accepted:    319.2K
 * Total Submissions: 716.5K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res);
        return res;
    }
    
    private void helper(int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length - 1) {
            List<Integer> cur = new ArrayList<>();
            for (int i : nums) {
                cur.add(i);
            }
            res.add(cur);            
            return;
        }
        
        Set<Integer> visited = new HashSet<>();  // <--
        
        for (int i = idx; i < nums.length; i++) {
            if (visited.contains(nums[i])) continue;  // <--
            visited.add(nums[i]);
            
            swap(nums, idx, i);
            helper(nums, idx + 1, res);
            swap(nums, idx, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end
