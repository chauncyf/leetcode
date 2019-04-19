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
        ListNode h1 = l1, h2 = l2, h3 = res;
        int flag = 0;

        while (h1 != null || h2 != null) {
            int val1 = (h1 == null) ? 0 : h1.val;
            int val2 = (h2 == null) ? 0 : h2.val;
            int val = val1 + val2 + flag;
            h3.next = new ListNode(val % 10);
            h3 = h3.next;
            flag = val / 10;
            if (h1 != null) h1 = h1.next;
            if (h2 != null) h2 = h2.next;
        }
        if (flag != 0) {
            h3.next = new ListNode(flag);
        }
        return res.next;
    }
}
