/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (55.84%)
 * Likes:    3074
 * Dislikes: 266
 * Total Accepted:    339.9K
 * Total Submissions: 591.3K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an array nums of n integers where n > 1,  return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does
 * not count as extra space for the purpose of space complexity analysis.)
 */

// @lc code=start
class Solution {
    /* w/ division */
    // public int[] productExceptSelf(int[] nums) {
    //     int[] res = new int[nums.length];
    //     int product = 1;
    //     for (int i : nums) {
    //         product *= i;
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         res[i] = product / nums[i];
    //     }
    //     return res;
    // }
    
    /* Prefix Product */
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) return nums;

        // prod for all element at left side
        int[] prodLeft = new int[nums.length];
        prodLeft[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prodLeft[i] = prodLeft[i - 1] * nums[i - 1];
        }
        
        // prod for all element at right side
        int[] prodRight = new int[nums.length];
        prodRight[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            prodRight[i] = prodRight[i + 1] * nums[i + 1];
        }
        
        int[] res = new int[nums.length];
        for (int i = 0 ; i < nums.length; i++) {
            res[i] = prodLeft[i] * prodRight[i];
        }
        
        return res;
    }

    /* O(1) Space */
    // public int[] productExceptSelf(int[] nums) {
    //     int[] res = new int[nums.length];
        
    //     // prefix prod of left side
    //     res[0] = 1;
    //     for (int i = 1; i < res.length; i++) {
    //         res[i] = res[i - 1] * nums[i - 1];
    //     }
        
    //     // prefix prod of right side on the fly
    //     int prodR = 1;
    //     for (int i = res.length - 1; i >= 0; i--) {
    //         res[i] = res[i] * prodR;
    //         prodR *= nums[i];
    //     }
        
    //     return res;
    // }

    /* Bonus, real O(1) space w/ division */
    // public int[] productExceptSelf(int[] nums) {
    //     int prod = 1;
    //     int zero = 0;
    //     for (int i : nums) {
    //         if (i != 0) prod *= i;
    //         else zero++;
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         if (zero == 0) {
    //             nums[i] = prod / nums[i];
    //         } else if (zero == 1 && nums[i] == 0) {  // this is that zero
    //             nums[i] = prod;
    //         } else {  // if more than one zero, then prod except itself will always be 0
    //             nums[i] = 0;
    //         }
    //     }
    //     return nums;
    // }
}
// @lc code=end
