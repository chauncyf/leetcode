/**
 * 23. Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        PriorityQueue<ListNode> minQ = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        for (ListNode l : lists) {
            if (l != null) {
                minQ.offer(l);
            }
        }
        while (!minQ.isEmpty()) {
            ListNode tmp = minQ.poll();
            cur.next = tmp;
            if (tmp.next != null) {
                minQ.offer(tmp.next);
            }
            cur = cur.next;
        }
        return res.next;
    }
}