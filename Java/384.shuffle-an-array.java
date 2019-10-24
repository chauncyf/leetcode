/*
 * @lc app=leetcode id=384 lang=java
 *
 * [384] Shuffle an Array
 *
 * https://leetcode.com/problems/shuffle-an-array/description/
 *
 * algorithms
 * Medium (50.45%)
 * Likes:    337
 * Dislikes: 775
 * Total Accepted:    92.6K
 * Total Submissions: 181.2K
 * Testcase Example:  '["Solution","shuffle","reset","shuffle"]\n[[[1,2,3]],[],[],[]]'
 *
 * Shuffle a set of numbers without duplicates.
 * 
 * 
 * Example:
 * 
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * 
 * // Shuffle the array [1,2,3] and return its result. Any permutation of
 * [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * 
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * 
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 * 
 * 
 */

// @lc code=start
class Solution {
    private Random random;
    private int[] org;
    private int[] nums;
    
    public Solution(int[] nums) {
        this.random = new Random();
        this.nums = nums;
        this.org = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            org[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = org[i];
        }
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int rand = random.nextInt(nums.length - i) + i;
            swap(nums, i, rand);
        }
        return nums;
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end
