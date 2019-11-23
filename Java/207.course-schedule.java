/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (38.58%)
 * Likes:    2447
 * Dislikes: 123
 * Total Accepted:    285.5K
 * Total Submissions: 714.4K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * 
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return true;
        Queue<Integer> queue = new LinkedList<>();
        int[] todo = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            todo[prerequisites[i][0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (todo[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.remove();
            for (int i = 0; i < prerequisites.length; i++) {
                if (pre == prerequisites[i][1]) {
                    if (--todo[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (todo[i] != 0) return false;
        }
        return true;
    }
}
// @lc code=end
