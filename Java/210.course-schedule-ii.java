/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 *
 * https://leetcode.com/problems/course-schedule-ii/description/
 *
 * algorithms
 * Medium (35.61%)
 * Likes:    1358
 * Dislikes: 95
 * Total Accepted:    189.6K
 * Total Submissions: 511.3K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you
 * should have finished   
 * course 0. So the correct course order is [0,1] .
 * 
 * Example 2:
 * 
 * 
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you
 * should have finished both     
 * ⁠            courses 1 and 2. Both courses 1 and 2 should be taken after you
 * finished course 0. 
 * So one correct course order is [0,1,2,3]. Another correct ordering is
 * [0,2,1,3] .
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
    int[] order;
    int idx;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        order = new int[numCourses];
        idx = 0;
        
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
            if (hasCircle(adjMap, courses, course)) return new int[]{};
        }
        
        for (int i = 0; idx < numCourses && i < numCourses; i++) {  // handle courses that dont have preq
            if (!courses.containsKey(i)) order[idx++] = i;
        }
        
        return order;
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
        order[idx++] = vertice;  // add course to order
        return false;
    }
}
// @lc code=end
