/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (36.61%)
 * Likes:    2038
 * Dislikes: 291
 * Total Accepted:    311.4K
 * Total Submissions: 836K
 * Testcase Example:  '[1,2]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /* Reverse First Half */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode lo = head, hi = head;
        ListNode pre = null, nex = null;
        while (hi != null && hi.next != null) {
            hi = hi.next.next;
            
            nex = lo.next;
            lo.next = pre;
            pre = lo;
            lo = nex;
        }
        lo = pre;
        hi = (hi == null) ? nex : nex.next;
        
        while (lo != null) {
            if (lo.val != hi.val) return false;
            lo = lo.next;
            hi = hi.next;
        }
        
        return true;
    }

    /* Reverse Second Half */
    // public boolean isPalindrome(ListNode head) {
    //     ListNode lo = head, hi = head;
    //     while (hi != null && hi.next != null) {
    //         lo = lo.next;
    //         hi = hi.next.next;
    //     }
    //     if (hi != null) lo = lo.next;  // skip center odd node
        
    //     // reverse second half
    //     ListNode pre = null, cur = lo;
    //     while (cur != null) {
    //         ListNode nex = cur.next;
    //         cur.next = pre;
    //         pre = cur;
    //         cur = nex;
    //     }
        
    //     hi = pre;
    //     lo = head;
    //     while (hi != null) {  // cannot use lo here, only reversed half has an end
    //         if (hi.val != lo.val) return false;
    //         hi = hi.next;
    //         lo = lo.next;
    //     }
        
    //     return true;
    // }
}
// @lc code=end
