/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (30.87%)
 * Likes:    1589
 * Dislikes: 650
 * Total Accepted:    339.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
class Solution {
    /*
        nums = "----->-->"; k =3
        result = "-->----->";

        reverse "----->-->" we can get "<--<-----"
        reverse "<--" we can get "--><-----"
        reverse "<-----" we can get "-->----->"
    */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    /* Naive */

    // public void rotate(int[] nums, int k) {
    //     k = k % nums.length;
    //     if (k == 0) return;
        
    //     int[] tmp = new int[k];
    //     for (int i = nums.length - k; i < nums.length; i++) {
    //         tmp[i - nums.length + k] = nums[i];
    //     }
    //     for (int i = nums.length - 1 - k; i >= 0; i--) {
    //         nums[i + k] = nums[i];
    //     }
    //     for (int i = 0; i < k; i++) {
    //         nums[i] = tmp[i];
    //     }
    // }

    // public void rotate(int[] nums, int k) {
    //     k = k % nums.length;
    //     int[] res = new int[nums.length];
    //     int idx = nums.length - 1;
    //     for (int i = nums.length - 1 - k; i >= 0; i--) {
    //         res[idx--] = nums[i];
    //     }
    //     for (int i = nums.length - 1; i >= nums.length - k; i--) {
    //         res[idx--] = nums[i];
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         nums[i] = res[i];
    //     }
    // }
}
