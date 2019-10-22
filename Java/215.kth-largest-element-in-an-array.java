/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (48.92%)
 * Likes:    2510
 * Dislikes: 195
 * Total Accepted:    453.7K
 * Total Submissions: 900.9K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 */

// @lc code=start
class Solution {
    // Quick Select Solution
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }
    
    public int quickSelect(int[] nums, int kth, int lo, int hi) {
        if (lo < hi) {
            int pi = partition(nums, lo, hi);
            if (pi == kth) {
                return nums[pi];
            } else if (pi < kth) {
                return quickSelect(nums, kth, pi + 1, hi);
            } else {
                return quickSelect(nums, kth, lo, pi - 1);
            }
        }
        return nums[kth];
    }
    
    private int partition(int[] nums, int lo, int hi) {
        // // Simple Pivot
        // int pivot = nums[hi];

        // Randomized pivot
        Random random = new Random();
        int pivotIndex = lo + random.nextInt(hi - lo);
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, hi);

        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (pivot > nums[j]) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, hi);
        return i + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // MinQ Solution
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> minQ = new PriorityQueue<>();        
    //     for (int i : nums) {
    //         minQ.offer(i);
    //         if (minQ.size() > k) {
    //             minQ.poll();
    //         }
    //     }
    //     return minQ.poll();
    // }
}
// @lc code=end
