/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 *
 * https://leetcode.com/problems/integer-to-english-words/description/
 *
 * algorithms
 * Hard (24.62%)
 * Likes:    760
 * Dislikes: 2165
 * Total Accepted:    139.6K
 * Total Submissions: 542.1K
 * Testcase Example:  '123'
 *
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 2^31 - 1.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * 
 * Example 3:
 * 
 * 
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty
 * Seven"
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty
 * Seven Thousand Eight Hundred Ninety One"
 * 
 * 
 */

// @lc code=start
class Solution {
    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        int count = 0;
        while (num != 0) {
            if (count > 0 && num % 1000 != 0) {
                res = thousands[count] + " " + res.trim();
            }
            res = hundredToWords(num % 1000) + " " + res;
            if (num >= 1000) {
                count++;
            } 
            num /= 1000;
            
        }
        return res.trim();
    }
    
    public String hundredToWords(int num) {
        String res = "";
        if (num >= 100) {
            res = ones[num / 100] + " Hundred";
            num %= 100;
        }
        if (num >= 20) {
            res = res + " " + tens[num / 10];
            num %= 10;
        }
        if (num > 0) {
            res = res + " " + ones[num];
        }
        return res;
    }
}
// @lc code=end
