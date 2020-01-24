/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (54.03%)
 * Likes:    2156
 * Dislikes: 54
 * Total Accepted:    392.1K
 * Total Submissions: 725.4K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {
    // Recursive
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        find(nums, new ArrayList<>(), 0);
        return res;
    }
    
    // private void find(int[] nums, List<Integer> set, int idx) {
    //     if (idx == nums.length) {
    //         res.add(new ArrayList<>(set));
    //         return;
    //     }
    //     find(nums, set, idx + 1);
    //     set.add(nums[idx]);
    //     find(nums, set, idx + 1);
    //     set.remove(set.size() - 1);
    // }

    private void helper(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
        if (idx <= nums.length) {
            res.add(new ArrayList<>(cur));
        }
        
        for (int i = idx; i < nums.length; i++) {
            // if (i > idx && nums[i] == nums[i - 1]) continue;  // rm dup
            cur.add(nums[i]);
            helper(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }

    
    // Iterative
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (nums.length == 0) return res;
        
    //     res.add(new ArrayList<>());
    //     for (int i = 0; i < nums.length; i++) {
    //         int size = res.size();
    //         for (int j = 0; j < size; j++) {
    //             List<Integer> sub = new ArrayList<>(res.get(j));
    //             sub.add(nums[i]);
    //             res.add(sub);
    //         }
    //     }
        
    //     return res;
    // }
}
