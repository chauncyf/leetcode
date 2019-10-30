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
 * 
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * 
 * Example 2:
 * 
 * Input: [[7,10],[2,4]]
 * Output: 1
 * 
 */

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer[]> minQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int room = 0;
        for (int[] interval : intervals) {
            if (minQ.isEmpty() || interval[0] < minQ.peek()[1]) {    
                minQ.offer(new Integer[]{interval[0], interval[1]});
                room = Math.max(room, minQ.size());
            } else {
                minQ.poll();
                minQ.offer(new Integer[]{interval[0], interval[1]});
            }
        }
        
        return room;
    }
}
