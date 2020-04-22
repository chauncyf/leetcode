/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 *
 * https://leetcode.com/problems/sort-an-array/description/
 *
 * algorithms
 * Medium (63.65%)
 * Likes:    166
 * Dislikes: 142
 * Total Accepted:    30.6K
 * Total Submissions: 48.7K
 * Testcase Example:  '[5,2,3,1]'
 *
 * Given an array of integers nums, sort the array in ascending order.
 * 
 * Example 1:
 * Input: [5,2,3,1]
 * Output: [1,2,3,5]
 * 
 * Example 2:
 * Input: [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * 
 * Note:
 * 1 <= A.length <= 10000
 * -50000 <= A[i] <= 50000
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    public void quickSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int pivotIdx = partition(nums, lo, hi);
            quickSort(nums, lo, pivotIdx - 1);
            quickSort(nums, pivotIdx + 1, hi);
        }
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int idx = lo;  // idx that element < pivot
        
        for (int i = lo; i < hi; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, idx++);
            }
        }
        swap(nums, hi, idx);
        
        return idx;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end
