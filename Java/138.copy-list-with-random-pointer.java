/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (28.03%)
 * Likes:    1741
 * Dislikes: 461
 * Total Accepted:    264.5K
 * Total Submissions: 940.1K
 * Testcase Example:  '{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}'
 *
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * 
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer
 * points to itself.
 * 
 * 
 * 
 * Note:
 * 
 * You must return the copy of the given head as a reference to the cloned
 * list.
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // duplicate nodes
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        // map random pointers
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;            
            }
            cur = cur.next.next; 
        }
        // get copied list
        cur = head;
        Node res = new Node(0);
        Node cur2 = res;                
        while (cur != null) {
            // Node next = cur.next;
            cur2.next = cur.next;
            cur2 = cur2.next; 
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return res.next;
    }
    
    // public Node copyRandomList(Node head) {
    //     Map<Node, Node> map = new HashMap<>();
    //     Node res = new Node();
    //     Node cur = head;
    //     while (cur != null) {
    //         map.put(cur, new Node(cur.val, cur.next, cur.random));
    //         cur = cur.next;
    //     }
    //     cur = head;
    //     Node newNode = res;
    //     while (cur != null) {
    //         newNode.next = map.get(cur);
    //         newNode.next.random = map.get(newNode.next.random);
    //         newNode = newNode.next;
    //         cur = cur.next;
    //     }
    //     return res.next;
    // } 
}
// @lc code=end
