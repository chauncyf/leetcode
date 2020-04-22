/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 *
 * https://leetcode.com/problems/binary-search/description/
 *
 * algorithms
 * Easy (48.59%)
 * Likes:    538
 * Dislikes: 42
 * Total Accepted:    117.4K
 * Total Submissions: 230.3K
 * Testcase Example:  '[-1,0,3,5,9,12]\n9'
 *
 * Given a sorted (in ascending order) integer array nums of n elements and a
 * target value, write a function to search target in nums. If target exists,
 * then return its index, otherwise return -1.
 * 
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * 
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * 
 * Note:
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    // public int search(int[] nums, int target) {
    //     return binarySearch(nums, target, 0, nums.length - 1);
    // }
    
    // public int binarySearch(int[] nums, int target, int lo, int hi) {
    //     if (lo > hi) return -1;
        
    //     int mid = (lo + hi) / 2;
    //     if (nums[mid] == target) return mid;
        
    //     if (nums[mid] < target) {
    //         return binarySearch(nums, target, mid + 1, hi);
    //     } else {
    //         return binarySearch(nums, target, lo, mid - 1);
    //     }
    // }
}
// @lc code=end
