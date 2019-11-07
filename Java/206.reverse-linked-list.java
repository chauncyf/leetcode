/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (55.90%)
 * Likes:    2937
 * Dislikes: 73
 * Total Accepted:    713.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * 
 * Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;  // head == null used to evaluate input
    
        ListNode res = reverseList(head.next);  // once find the last tail, will not be changed afterward
        head.next.next = head; 
        head.next = null;
        return res;
    }

    // public ListNode reverseList(ListNode head) {
    //     ListNode pre = null;
    //     ListNode cur = head;
    //     while (cur != null) {
    //         ListNode nex = cur.next;
    //         cur.next = pre;
    //         pre = cur;
    //         cur = nex;
    //     }
    //     return pre;
    // }

    // public ListNode reverseList(ListNode head) {
    //     if (head == null) return null;
        
    //     ListNode pre = head, cur = head.next;
    //     while (cur != null) {
    //         pre.next = cur.next;
    //         cur.next = head;
    //         head = cur;
    //         cur = pre.next;  
    //     }
        
    //     return head;
    // }
}
// @lc code=end
