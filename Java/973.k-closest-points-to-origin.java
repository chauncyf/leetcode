/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/description/
 *
 * algorithms
 * Medium (61.71%)
 * Likes:    791
 * Dislikes: 75
 * Total Accepted:    128.3K
 * Total Submissions: 209.7K
 * Testcase Example:  '[[1,3],[-2,2]]\n1'
 *
 * We have a list of points on the plane.  Find the K closest points to the
 * origin (0, 0).
 * 
 * (Here, the distance between two points on a plane is the Euclidean
 * distance.)
 * 
 * You may return the answer in any order.  The answer is guaranteed to be
 * unique (except for the order that it is in.)
 * 
 * 
 * Example 1:
 * 
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation: 
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just
 * [[-2,2]].
 * 
 * 
 * Example 2:
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * 
 * 
 * Note:
 * 
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 * 
 */

// @lc code=start
class Solution {
    /* Quick Select */
    public int[][] kClosest(int[][] points, int K) {
        quickSelect(points, K, 0, points.length - 1);
        return Arrays.copyOf(points, K);
    }
    
    public void quickSelect(int[][] nums, int k, int lo, int hi) {
        if (lo < hi) {
            int pi = partition(nums, lo, hi);
            if (pi == k - 1) return;
            if (pi < k - 1) quickSelect(nums, k, pi + 1, hi);
            else quickSelect(nums, k, lo, pi - 1);
        }
    }
    
    private int partition(int[][] nums, int lo, int hi) {
        int[] pivot = nums[hi];
        int idx = lo;
        for (int i = lo; i < hi; i++) {
            if (distance(nums[i]) <= distance(pivot)) {
                swap(nums, i, idx);
                idx++;
            }
        }
        swap(nums, idx, hi);
        return idx;
    }
    
    private void swap(int[][] nums, int i, int j) {
        int[] tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }


    /* Wrap MaxQ */
    // class Point {
    //     int x;
    //     int y;
    //     int distance;
    //     public Point(int[] point) {
    //         this.x = point[0];
    //         this.y = point[1];
    //         this.distance = point[0] * point[0] + point[1] * point[1];
    //     }
    //     public int[] getPoint() {
    //         return new int[]{this.x, this.y};
    //     }
    // }
    
    // public int[][] kClosest(int[][] points, int K) {
    //     int[][] res = new int[K][2];
    //     PriorityQueue<Point> maxQ = new PriorityQueue<>((a, b) -> b.distance - a.distance);
    //     for (int[] point : points) {
    //         maxQ.offer(new Point(point));
    //         if (maxQ.size() > K) maxQ.poll();
    //     }
    //     for (int i = 0; i < K; i++) {
    //         res[i] = maxQ.poll().getPoint();            
    //     }
    //     return res;
    // }

    /* MaxQ */
    // public int[][] kClosest(int[][] points, int K) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
    //     for (int[] point : points) {
    //         int dist = point[0] * point[0] + point[1] * point[1];
    //         pq.add(dist);
    //         if (pq.size() > K) {
    //             pq.poll();
    //         }
    //     }
    //     int kthDist = pq.poll();
    //     int[][] res = new int[K][2];
    //     int x = 0;
    //     for (int i = 0; i < points.length; i++) {
    //         int[] point = points[i];
    //         int dist = point[0] * point[0] + point[1] * point[1];
    //         if (dist <= kthDist) {
    //             res[x++] = points[i];
    //         }
    //     }
    //     return res;
    // }
}
// @lc code=end
