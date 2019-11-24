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
    /* Topological Sort Based on DFS Circle Detection */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adjMap = new HashMap<>();  // course -> preqs
        Map<Integer, Integer> courses = new HashMap<>();  // 0: not visited, 1: visiting, 2: visited
        for (int[] pre : prerequisites) {
            // assume all pres are pair of 2
            Set<Integer> set = adjMap.getOrDefault(pre[0], new HashSet<>());  
            set.add(pre[1]);
            adjMap.put(pre[0], set);
            courses.put(pre[0], 0);
            courses.put(pre[1], 0);
        }
        for (Integer course : courses.keySet()) {
            if (hasCircle(adjMap, courses, course)) return false;
        }
        return true;
    }
    
    private boolean hasCircle(Map<Integer, Set<Integer>> adjMap, Map<Integer, Integer> vertices, Integer vertice) {
        if (vertices.get(vertice) == 2) return false;
        if (vertices.get(vertice) == 1) return true;
        vertices.put(vertice, 1);  // mark as visiting
        if (adjMap.containsKey(vertice)) {  // if this vertice has forward edges (has preqs)
            for (Integer preq : adjMap.get(vertice)) {
               if (hasCircle(adjMap, vertices, preq)) return true;
            }
        }
        vertices.put(vertice, 2);  // mark as visited
        return false;
    }


    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     if (numCourses <= 0) return true;
    //     Queue<Integer> queue = new LinkedList<>();
    //     int[] todo = new int[numCourses];
    //     for (int i = 0; i < prerequisites.length; i++) {
    //         todo[prerequisites[i][0]]++;
    //     }
    //     for (int i = 0; i < numCourses; i++) {
    //         if (todo[i] == 0) {
    //             queue.add(i);
    //         }
    //     }
    //     while (!queue.isEmpty()) {
    //         int pre = queue.remove();
    //         for (int i = 0; i < prerequisites.length; i++) {
    //             if (pre == prerequisites[i][1]) {
    //                 if (--todo[prerequisites[i][0]] == 0) {
    //                     queue.add(prerequisites[i][0]);
    //                 }
    //             }
    //         }
    //     }
    //     for (int i = 0; i < numCourses; i++) {
    //         if (todo[i] != 0) return false;
    //     }
    //     return true;
    // }
}
// @lc code=end
