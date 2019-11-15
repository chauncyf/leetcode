/*
 * @lc app=leetcode id=716 lang=java
 *
 * [716] Max Stack
 *
 * https://leetcode.com/problems/max-stack/
 *
 * Design a max stack that supports push, pop, top, peekMax and popMax. 
 * 
 *      push(x) -- Push element x onto stack. 
 *      pop() -- Remove the element on top of the stack and return it.
 *      top() -- Get the element on the top.
 *      peekMax() -- Retrieve the maximum element in the stack.
 *      popMax() -- Retrieve the maximum element in the stack, and remove it. 
 *                  If you find more than one maximum elements, only remove the top-most one.
 * 
 * 
 * Example 1:
 * 
 * MaxStack stack = new MaxStack();
 * stack.push(5); 
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * 
 * Note:
 * 
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 * 
 */

class MaxStack {
    private int max;
    private Stack<Integer> stack;
    
    /** initialize your data structure here. */
    public MaxStack() {
        this.stack = new Stack<>();
        this.max = Integer.MIN_VALUE;
    }
    
    public void push(int x) {
        if (x >= max) {
            stack.push(max);
            max = x;
        }
        stack.push(x);
    }
    
    public int pop() {
        int val = stack.pop();
        if (val == max) max = stack.pop();
        return val;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return max;
    }
    
    public int popMax() {
        Stack<Integer> tmpStack = new Stack<>();
        int res = max;
        while (!stack.isEmpty()) {
            // int val = pop();
            // if (val == max) break;
            int val = stack.pop();
            if (val == max) {
                max = stack.pop();
                break;
            }
            tmpStack.push(val);
        }
        while (!tmpStack.isEmpty()) {
            this.push(tmpStack.pop());
        }
        return res;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
