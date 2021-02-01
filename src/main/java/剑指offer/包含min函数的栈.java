package 剑指offer;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 * @author zz
 * @date 2021/2/1 13:58
 */
public class 包含min函数的栈 {

    private Stack<Integer> dataStack;

    private Stack<Integer> minStack;

    /**
     * 做法：两个栈，一个数据栈，一个最值栈
     * 每次有数据都往数据栈中压入，只有当数小于最值栈的栈顶才压入最值栈
     * 弹出时从数据栈中弹出，当最值栈的栈顶等于数据栈弹出的数据时才弹出最值栈
     */
    /** initialize your data structure here. */
    public 包含min函数的栈() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else if (minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("栈中元素为空!");
        }
        Integer data = dataStack.pop();
        if (!minStack.isEmpty() && minStack.peek().equals(data)) {
            minStack.pop();
        }
    }

    public int top() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("栈中元素为空!");
        }
        return dataStack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("栈中元素为空!");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        /**
         * ["MinStack","push","push","push","push","pop","min","pop","min","pop","min"]
         * [[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]
         * [null,null,null,null,null,null,-1024,null,-1024,null,512]
         */
        包含min函数的栈 stack = new 包含min函数的栈();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }

}
