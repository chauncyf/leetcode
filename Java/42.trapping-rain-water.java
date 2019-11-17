/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (43.96%)
 * Likes:    3965
 * Dislikes: 73
 * Total Accepted:    317.7K
 * Total Submissions: 722.8K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 */

// @lc code=start
class Solution {
    /* DP */
    public int trap(int[] height) {
        // for each index, amount of rain it can trap = Min(max height of left, max height of right) - height of itself
        // so we want to know, for each index, max height of left so far, and max height of right so far

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i == 0) maxLeft[i] = height[i];
            else maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) maxRight[i] = height[i];
            else maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return res;
    }

    /* Two Pointer */
    // public int trap(int[] height) {
    //     int res = 0;
    //     int maxLeft = 0, maxRight = 0;
    //     int le = 0, ri = height.length - 1;
    //     while (le <= ri) {
    //         if (maxLeft <= maxRight) {  // if upper bound constrained by left side
    //             if (height[le] >= maxLeft) maxLeft = height[le];
    //             else res += maxLeft - height[le];
    //             le++;
    //         } else {  // else if upper bound constrained by right side
    //             if (height[ri] >= maxRight) maxRight = height[ri];
    //             else res += maxRight - height[ri];
    //             ri--;
    //         }
    //     }
    //     return res;
    // }
}
// @lc code=end
