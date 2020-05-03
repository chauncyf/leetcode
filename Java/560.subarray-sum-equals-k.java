/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (42.53%)
 * Likes:    2690
 * Dislikes: 71
 * Total Accepted:    156.4K
 * Total Submissions: 363K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * 
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the
 * integer k is [-1e7, 1e7].
 */

// @lc code=start
class Solution {
    /* prefix sum */
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // sum -> freq
        map.put(0, 1);  // incase that nums[i] == k
        for (int i : nums) {
            sum += i;
            if (map.containsKey(sum - k)) res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    /* brute force */
    // public int subarraySum(int[] nums, int k) {
    //     int res = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         int curSum = 0;
    //         for (int j = i; j < nums.length; j++) {
    //             curSum += nums[j];
    //             if (curSum == k) res++;
    //         }
    //     }
    //     return res;
    // }
}
// @lc code=end
