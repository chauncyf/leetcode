/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (55.72%)
 * Likes:    497
 * Dislikes: 912
 * Total Accepted:    264.5K
 * Total Submissions: 461K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * 
 * 
 * Note:
 * 
 * 
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) set.add(i);
        List<Integer> intersect = new LinkedList<>();            
        for (int i : nums2) {
            if (set.contains(i)) {
                intersect.add(i);
                set.remove(i);
            }
        }
        int[] res = new int[intersect.size()];
        for (int i = 0; i < intersect.size(); i++){
            res[i] = intersect.get(i);
        }
        return res;
    }
}
// @lc code=end
