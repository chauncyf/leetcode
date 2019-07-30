import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (35.32%)
 * Likes:    2696
 * Dislikes: 173
 * Total Accepted:    420.3K
 * Total Submissions: 1.2M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 
 * 
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
        PriorityQueue<ListNode> minQ = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);  // dont add size :)
        for (ListNode l : lists) {
            if (l != null) {  // :)
                minQ.offer(l);
            }
        }
        while (!minQ.isEmpty()) {
            ListNode curNode = minQ.poll();
            cur.next = curNode;
            cur = cur.next;
            if (curNode.next != null) {
                minQ.offer(curNode.next);
            }
        } 
        return res.next;
    }
}

