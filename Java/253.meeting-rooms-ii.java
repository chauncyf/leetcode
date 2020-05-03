/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 *
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 * 
 * Example 1:
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * 
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: 1
 */

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);        
        PriorityQueue<Integer[]> minQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for (int[] i : intervals) {
            // if current interval's start time > smallest end time in the minQ, we know that we can use that room
            // otherwise, we need a new room
            if (!minQ.isEmpty() && i[0] >= minQ.peek()[1]) minQ.poll();
            minQ.offer(new Integer[]{i[0], i[1]});
        }
        
        return minQ.size();
    }
}
