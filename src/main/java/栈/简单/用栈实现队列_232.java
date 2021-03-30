package 栈.简单;

import java.util.Stack;

/**
 * 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * 你只能使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 进阶：
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 * 示例：
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
\\
 * @author zz
 * @date 2021/1/13 10:06
 */
public class 用栈实现队列_232 {

    private Stack<Integer> pushStack;

    private Stack<Integer> popStack;

    /**
     * 做法：两个栈，一个推入栈，一个弹出栈
     * 推入栈负责推入元素
     * 弹出栈负责弹出元素，如果弹出栈没有元素，则将推入栈的元素全部倒到弹出栈
     */
    public 用栈实现队列_232() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!popStack.isEmpty()) {
            return popStack.pop();
        }
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        if (!popStack.isEmpty()) {
            return popStack.pop();
        }
        throw new RuntimeException("栈中元素为空");
    }

    /** Get the front element. */
    public int peek() {
        if (!popStack.isEmpty()) {
            return popStack.peek();
        }
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        if (!popStack.isEmpty()) {
            return popStack.peek();
        }
        throw new RuntimeException("栈中元素为空");
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }

}
