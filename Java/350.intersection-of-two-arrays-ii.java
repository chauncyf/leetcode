/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 *
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 *
 * algorithms
 * Easy (48.43%)
 * Likes:    1169
 * Dislikes: 373
 * Total Accepted:    317K
 * Total Submissions: 625.3K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * 
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in both
 * arrays.
 * The result can be in any order.
 * 
 * Follow up:
 * What if the given array is already sorted? How would you optimize your
 * algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is
 * better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.getOrDefault(i, 0) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /* if sorted */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<>();
        int i1 = 0, i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                list.add(nums1[i1]);
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
// @lc code=end
