/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (36.16%)
 * Likes:    2718
 * Dislikes: 215
 * Total Accepted:    435K
 * Total Submissions: 1.2M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<Integer[]> res = new ArrayList<>();
        int index = -1;
        for (int[] interval : intervals) {
            if (res.size() == 0 || res.get(index)[1] < interval[0]) {
                res.add(new Integer[]{interval[0], interval[1]});
                index++;
            } else {
                Integer[] tmp = res.get(index);
                tmp[0] = Math.min(tmp[0], interval[0]);
                tmp[1] = Math.max(tmp[1], interval[1]);
                res.set(index, tmp);
            }
        }
        
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        
        return ans;
    }

    // public int[][] merge(int[][] intervals) {
    //     if (intervals.length == 0) return intervals;
        
    //     Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
    //     int[][] res = new int[intervals.length][2];
    //     res[0] = intervals[0];
    //     int idx = 0;
    //     for (int i = 1; i < intervals.length; i++) {
    //         if (intervals[i][0] <= res[idx][1]) {
    //             res[idx][1] = Math.max(res[idx][1], intervals[i][1]);
    //         } else {
    //             res[++idx] = intervals[i];
    //         }
    //     }
        
    //     return Arrays.copyOf(res, idx + 1);
    // }
}
// @lc code=end
