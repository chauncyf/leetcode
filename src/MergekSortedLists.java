import java.util.Comparator;
import java.util.PriorityQueue;

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

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // PriorityQueue<ListNode> minQ = new PriorityQueue<>(lists.length, (ListNode l1, ListNode l2) -> l1.val - l2.val);
        PriorityQueue<ListNode> minQ = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        for (ListNode node: lists) {
            if (node != null) minQ.offer(node);
        }
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (!minQ.isEmpty()) {
            cur.next = minQ.poll();
            cur = cur.next;
            if (cur.next != null) {
                minQ.offer(cur.next);
            }
        }
        return res.next;
    }
}
