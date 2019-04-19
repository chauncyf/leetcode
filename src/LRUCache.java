import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 / capacity / );
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */

public class LRUCache {
    ListNode head, tail;
    Map<Integer, ListNode> map;
    int capacity;

    class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
    }

    private void addNode(ListNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // node.prev = null;
        // node.next = null;
    }

    private ListNode removeNode() {
        ListNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void moveToHead(ListNode node) {
        removeNode(node);
        addNode(node);
    }


    public LRUCache(int capacity) {
        this.head = new ListNode();
        this.tail = new ListNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;

        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode res = map.get(key);
            moveToHead(res);
            return res.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            moveToHead(node);
        }
        else {
            ListNode node = new ListNode();
            node.key = key;
            node.val = value;
            if (map.size() == capacity) {
                ListNode del = removeNode();
                map.remove(del.key);
            }
            addNode(node);
            map.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */