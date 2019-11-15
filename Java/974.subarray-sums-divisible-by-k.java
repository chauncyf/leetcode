/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 *
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
 *
 * algorithms
 * Medium (45.96%)
 * Likes:    455
 * Dislikes: 41
 * Total Accepted:    19.2K
 * Total Submissions: 40.9K
 * Testcase Example:  '[4,5,0,-2,-3,1]\n5'
 *
 * Given an array A of integers, return the number of (contiguous, non-empty)
 * subarrays that have a sum divisible by K.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2,
 * -3]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * 
 */

// @lc code=start
class Solution {
    /*
        Prefix Sum
        
        Logic:
        I am already going to assume that you know about prefix sums before you read this.
        We can all agree that for an array int[] A, where N = len(A), that there are N prefix sums.
        prefix[0] = A[0], prefix[1] = A[0] + A[1], ... prefix[i] = A[0] + ... + A[i].

        Then to calculate how many subarrays are divisible by K is logically equivalent to saying, how many ways can we pair up all prefix sum pairs (i,j) where i < j
        such that (prefix[j] - prefix[i]) % K == 0.

        Just from that information alone we easily get a O(n^2) solution.
        Compute all prefix sums, then check all pair to see if k divides the difference between them.

        However, if we just exploit some information w.r.t to the remainder of each prefix sum we can manipulate this into a linear algorithm. Here's how.

        Number Theory Part:       
        I noted above that we need to find all prefix sum pairs (i,j) such tha (p[j] - p[i]) % K == 0.
        But this is only true, if and only if p[j] % K == p[i] % K
        Why is this?

        According the the division algorithm we can express p[j] and p[i] in the following way.
        p[j] = bK + r0 where 0 <= r0 < K
        p[i] = aK + r1 where 0<= r1 < K

        Then p[j] - p[i] = (b*K + r0) - (a*K + r1)
        = b*K - a*K + r0 - r1 = K*(b-a) + r0 - r1
        Again: p[j] - p[i] = K*(b-a) + (r0-r1), in other words
        K only divides p[j] - p[i] iff r0-r1 = 0 <-> r0 = r1 QED
     */
    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : A) {
            sum += i;
            int mod = sum % K;
            if (mod < 0) mod += K;  // -1 % 5 = -1, but we need the positive mod 4
            res += map.getOrDefault(mod, 0);  // if sum[0, i] % K == sum[0, j] % K, sum[i + 1, j] is divisible by by K
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return res;
    }

    /* Brute Force */
    // public int subarraysDivByK(int[] A, int K) {
    //     int res = 0;
    //     for (int i = 0; i < A.length; i++) {
    //         int curSum = 0;
    //         for (int j = i; j < A.length; j++) {
    //             curSum += A[j];
    //             if (curSum % K == 0) res++;
    //         }
    //     }
    //     return res;
    // }
}
// @lc code=end
