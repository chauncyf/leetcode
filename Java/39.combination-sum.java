/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (49.73%)
 * Likes:    2573
 * Dislikes: 78
 * Total Accepted:    410.9K
 * Total Submissions: 800.1K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        find(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void find(int[] candidates, int target, int index, List<Integer> comb, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            comb.add(candidates[i]);
            find(candidates, target - candidates[i], i, comb, res);
            comb.remove(comb.size() - 1);
        }
    }

    
    /* Follow Up */
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     Arrays.sort(candidates); // sort the array, so the result could be increasing order
    //     List<List<Integer>> result = new ArrayList<List<Integer>>();

    //     for(int i = 0; i < candidates.length; i++){
    //         // target smaller than current number, jump the current and rest of numbers
    //         if(target < candidates[i]) continue;

    //         // if target is equal to the current number,add it to a new list and add that list to result          
    //         else if(target == candidates[i]){
    //             List<Integer> set = new ArrayList<Integer>();
    //             set.add(candidates[i]);
    //             result.add(set);
    //         }

    //         // if the target is smaller the current number,call this function again
    //         else{
    //             // use modified array which not includes those numbers that before i to eliminate the duplicates
    //             int[] array = Arrays.copyOfRange(candidates,i,candidates.length);

    //             // call this function. pass the new target and modified array.
    //             List<List<Integer>> temp = combinationSum(array, target - candidates[i]);

    //             // for each list in the return list, add current number in the front of list, then add it to result
    //             // attention that if return list is null, this enhanced for loop will not perform. 
    //             for(List<Integer> list:temp){
    //                 list.add(0,candidates[i]);
    //                 result.add(list);
    //             } 
    //         }
    //     }

    //     return result;
    // }


    /* Same to Word Break II, without memoize, with duplicate */

    // List<List<Integer>> res;
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     res = new ArrayList<>();        
    //     Set<Integer> set = new HashSet<>();
    //     for (int i : candidates) set.add(i);
    //     find(set, target, new ArrayList<>());
    //     return res;
    // }
    // private void find(Set<Integer> nums, int target, List<Integer> comb) {        
    //     if (target == 0) {
    //         res.add(new ArrayList<>(comb));
    //         return;
    //     }
    //     for (int i = 1; i <= target; i++) {
    //         if (nums.contains(i)) {                                
    //             comb.add(i);
    //             find(nums, target - i, comb);
    //             comb.remove(comb.size() - 1);  // backtrack
    //         }
    //     }
    // }
}
// @lc code=end
