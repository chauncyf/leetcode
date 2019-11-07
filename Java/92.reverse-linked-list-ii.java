/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (35.55%)
 * Likes:    1554
 * Dislikes: 107
 * Total Accepted:    223.2K
 * Total Submissions: 612.6K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;
        
        ListNode dummyHead = new ListNode(0);  // incase reversed from first node
        dummyHead.next = head;
        
        ListNode pre = dummyHead;  // tail of first half
        ListNode cur = head;
        while (--m > 0) {
            pre = cur;  
            cur = cur.next;
            n--;
        }
        
        ListNode revTail = cur;  // tail of reversed part
        ListNode preTmp = null;
        while (--n > 0) {
            ListNode nexTmp = cur.next;
            cur.next = preTmp;
            preTmp = cur;
            cur = nexTmp;
        }
        
        ListNode secHead = cur.next;  // head of second half
        cur.next = preTmp;  // head of reversed part
        
        pre.next = cur;
        revTail.next = secHead;
        
        return dummyHead.next;
    }
}
// @lc code=end
