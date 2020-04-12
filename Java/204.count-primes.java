/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (29.48%)
 * Likes:    1383
 * Dislikes: 465
 * Total Accepted:    284.6K
 * Total Submissions: 943.7K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */

// @lc code=start
class Solution {

    /* nlog(n) */
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                // all multiples of i are not prime 
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }


    // public int countPrimes(int n) {
    //     int res = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (isPrime(i)) res++;
    //     }
    //     return res;
    // }
    
    // public boolean isPrime(int n) {
    //     if (n <= 1) return false;
    //     /*
    //         Let's start with a isPrime function. 
    //         To determine if a number is prime, we need to check if it is not divisible by any number less than n. 
    //         The runtime complexity of isPrime function would be O(n) and hence counting the total prime numbers up to n would be O(n2). 
    //         Could we do better?
    //     */
    //     // for (int i = 2; i < n; i++) {

    //     /*
    //         As we know the number must not be divisible by any number > n / 2, 
    //         we can immediately cut the total iterations half by dividing only up to n / 2. 
    //         Could we still do better?
    //     */
    //     // for (int i = 2; i <= n / 2; i++) {

    //     /*
    //         Let's write down all of 12's factors:

    //         2 × 6 = 12
    //         3 × 4 = 12
    //         4 × 3 = 12
    //         6 × 2 = 12
    //         As you can see, calculations of 4 × 3 and 6 × 2 are not necessary. 
    //         Therefore, we only need to consider factors up to √n because, if n is divisible by some number p, then n = p × q and since p ≤ q, we could derive that p ≤ √n.

    //         Our total runtime has now improved to O(n1.5), which is slightly better. Is there a faster approach?
    //     */
    //     for (int i = 2; i * i <= n; i++) {
    //         if (n % i == 0) return false;
    //     }
    //     return true;
    // }

    // /*
    //     4 is not a prime because it is divisible by 2, which means all multiples of 4 must also be divisible by 2 and were already marked off. 
    //     So we can skip 4 immediately and go to the next number, 5. 
    //     Now, all multiples of 5 such as 5 × 2 = 10, 5 × 3 = 15, 5 × 4 = 20, 5 × 5 = 25, ... can be marked off. 
    //     There is a slight optimization here, we do not need to start from 5 × 2 = 10. 
    //     Where should we start marking off?
    // */
    // public int countPrimes(int n) {
    //     boolean[] isPrime = new boolean[n];
    //     for (int i = 2; i < n; i++) {
    //        isPrime[i] = true;
    //     }
    //     // Loop's ending condition is i * i < n instead of i < sqrt(n)
    //     // to avoid repeatedly calling an expensive function sqrt().
    //     for (int i = 2; i * i < n; i++) {
    //        if (!isPrime[i]) continue;
    //        for (int j = i * i; j < n; j += i) {
    //           isPrime[j] = false;
    //        }
    //     }
    //     int count = 0;
    //     for (int i = 2; i < n; i++) {
    //        if (isPrime[i]) count++;
    //     }
    //     return count;
    //  }
}
// @lc code=end
