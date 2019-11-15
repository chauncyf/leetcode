/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.29%)
 * Likes:    4054
 * Dislikes: 464
 * Total Accepted:    584.5K
 * Total Submissions: 2.4M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int cur = nums[i] + nums[lo] + nums[hi];
                    if (cur == 0) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo + 1] == nums[lo]) lo++;
                        while (lo < hi && nums[hi - 1] == nums[hi]) hi--;
                        lo++;
                        hi--;
                    } else if (cur < 0) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}

