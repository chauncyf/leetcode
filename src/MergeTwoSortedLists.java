/**
 * 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode h1 = l1, h2 = l2, h3 = res;
        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                h3.next = h1;
                h1 = h1.next;
            } else {
                h3.next = h2;
                h2 = h2.next;
            }
            h3 = h3.next;
        }
        if (h1 != null) {
            h3.next = h1;
        }
        if (h2 != null) {
            h3.next = h2;
        }
        return res.next;
    }
}
