/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur1 = l1, cur2 = l2, cur = res;
        int payload = 0;
        
        while (cur1 != null || cur2 != null) {
            if (cur1 != null) {
                payload += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                payload += cur2.val;
                cur2 = cur2.next;
            }
            cur.next = new ListNode(payload % 10);
            cur = cur.next;
            payload /= 10;
        }
        if (payload != 0) {
            cur.next = new ListNode(payload);
        }
        return res.next;
    }
}
