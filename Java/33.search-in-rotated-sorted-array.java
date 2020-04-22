/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (33.05%)
 * Likes:    3098
 * Dislikes: 368
 * Total Accepted:    501.1K
 * Total Submissions: 1.5M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;  // prevent overflow if lo + hi is too big
            if (nums[mid] == target) return mid;
            
            // left is sorted
            if (nums[lo] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        
        return -1;
    }

    // public int search(int[] nums, int target) {
    //     if (nums.length == 0) return -1;
    //     if (nums.length == 1) return (nums[0] == target) ? 0 : -1;
        
    //     int rotateIndex = findRotateIndex(nums);
    //     int le = 0, ri = nums.length - 1;
        
    //     if (rotateIndex != 0) {
    //         if (target >= nums[0] && target <= nums[rotateIndex - 1]) {
    //             le = 0;
    //             ri = rotateIndex - 1;
    //         } else {
    //             le = rotateIndex;
    //             ri = nums.length - 1;
    //         }
    //     }
        
    //     return binarySearch(nums, target, le, ri);
    // }
    
    // private int findRotateIndex(int[] nums){
    //     int left = 0, right = nums.length - 1;
    //     if (nums[left] < nums[right]) return 0;
        
    //     while (left <= right) {
    //         int mid = (left + right) / 2;
    //         if (nums[mid] > nums[mid + 1]) {
    //             return mid + 1;
    //         }
    //         if (nums[mid] < nums[left]) {
    //             right = mid - 1;
    //         } else {
    //             left = mid +1;
    //         }
    //     }
        
    //     return 0;
    // }
    
    // private int binarySearch(int[] nums, int target, int left, int right) {
    //     while (left <= right) {
    //         int mid = (left + right) / 2;
    //         if (nums[mid] == target) return mid;
    //         if (nums[mid] > target) right = mid - 1;
    //         else left = mid + 1;
    //     }
    //     return -1;
    // }
}
// @lc code=end
