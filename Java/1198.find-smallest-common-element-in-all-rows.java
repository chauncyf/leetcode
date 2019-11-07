/*
 * @lc app=leetcode id=1198 lang=java
 *
 * [1198] Find Smallest Common Element in All Rows
 *
 * https://leetcode.com/problems/find-smallest-common-element-in-all-rows/
 *
 * 
 * Given a matrix mat where every row is sorted in increasing order, return the smallest common element in all rows.
 * 
 * If there is no common element, return -1.
 * 
 * 
 * Example 1:
 * 
 * Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
 * Output: 5
 * 
 * 
 * Constraints:
 * 
 * 1 <= mat.length, mat[i].length <= 500
 * 1 <= mat[i][j] <= 10^4
 * mat[i] is sorted in increasing order.
 * 
 */

class Solution {
    public int smallestCommonElement(int[][] mat) {
        int[] pos = new int[mat.length];
        int curMax = -1;
        int count = 0;
        while (true) {
            for (int r = 0; r < mat.length; r++) {
                if (pos[r] >= mat[r].length) return -1;
                
                int cur = mat[r][pos[r]];                
                if (cur == curMax) {
                    if (++count == mat.length) return cur;
                }
                else if (cur > curMax) {
                    curMax = cur;
                    count = 0;  // cannot be 1, because we want a full iteration
                } 
                else {
                    while (pos[r] < mat[r].length && mat[r][pos[r]] < curMax) pos[r]++;
                }
            }
        }
    }

    // public int smallestCommonElement(int[][] mat) {
    //     int[] bucket = new int[10001]; 
    //     for (int r = 0; r < mat.length; r++) {
    //         for (int c = 0; c < mat[0].length; c++) {
    //             // if (c != 0 && mat[r][c] == mat[r][c - 1]) continue;  // if have dup
    //             if (++bucket[mat[r][c]] == mat.length) return mat[r][c];
    //         }
    //     }
    //     return -1;
    // } 
}
