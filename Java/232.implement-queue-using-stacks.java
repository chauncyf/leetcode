/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 *
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 * algorithms
 * Easy (44.18%)
 * Likes:    704
 * Dislikes: 121
 * Total Accepted:    173.5K
 * Total Submissions: 380.1K
 * Testcase Example:  '["MyQueue","push","push","peek","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * Implement the following operations of a queue using stacks.
 * 
 * 
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * 
 * 
 * Example:
 * 
 * 
 * MyQueue queue = new MyQueue();
 * 
 * queue.push(1);
 * queue.push(2);  
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * 
 * Notes:
 * 
 * 
 * You must use only standard operations of a stack -- which means only push to
 * top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may
 * simulate a stack by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek
 * operations will be called on an empty queue).
 * 
 * 
 */

// @lc code=start
class MyQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    private int peek = Integer.MIN_VALUE;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.isEmpty()) peek = x;
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!stack2.isEmpty()) return stack2.peek();
        return peek;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}


// class MyQueue {
//     private Stack<Integer> stack1;
//     private Stack<Integer> stack2;
//     private int peek;
    
//     /** Initialize your data structure here. */
//     public MyQueue() {
//         this.stack1 = new Stack<>();
//         this.stack2 = new Stack<>();
//         peek = Integer.MIN_VALUE;
//     }
    
//     /** Push element x to the back of queue. */
//     public void push(int x) {
//         if (stack1.isEmpty()) peek = x;
//         stack1.push(x);
//     }
    
//     /** Removes the element from in front of queue and returns that element. */
//     public int pop() {
//         while (!stack1.isEmpty()) {
//             stack2.push(stack1.pop());
//         }
//         int res = stack2.pop();
//         peek = stack2.isEmpty() ? Integer.MIN_VALUE : stack2.peek();
//         while (!stack2.isEmpty()) {
//             stack1.push(stack2.pop());
//         }
//         return res;
//     }
    
//     /** Get the front element. */
//     public int peek() {
//         return peek;
//     }
    
//     /** Returns whether the queue is empty. */
//     public boolean empty() {
//         return stack1.isEmpty();
//     }
// }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
