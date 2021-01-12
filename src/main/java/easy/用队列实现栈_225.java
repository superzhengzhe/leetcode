package easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用队列实现栈
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * @author zz
 * @date 2021/1/12 10:44
 */
public class 用队列实现栈_225 {

    private Queue<Integer> queue1;

    private Queue<Integer> queue2;

    /**
     * 做法：两个队列
     */
    /** Initialize your data structure here. */
    public 用队列实现栈_225() {
        this.queue1 = new ArrayDeque();
        this.queue2 = new ArrayDeque();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.add(x);
        } else {
            queue1.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int data;
        if (queue1.isEmpty()) {
            data = pop(queue2, queue1);
        } else if (queue2.isEmpty()) {
            data = pop(queue1, queue2);
        } else {
            throw new RuntimeException("栈中元素为空");
        }
        return data;
    }

    private int pop(Queue<Integer> dataQueue, Queue<Integer> emptyQueue) {
        Integer data = null;
        while (!dataQueue.isEmpty()) {
            data = dataQueue.poll();
            if (dataQueue.size() != 0) {
                emptyQueue.add(data);
            }
        }
        return data;
    }

    /** Get the top element. */
    public int top() {
        int data;
        if (queue1.isEmpty()) {
            data = top(queue2, queue1);
        } else if (queue2.isEmpty()) {
            data = top(queue1, queue2);
        } else {
            throw new RuntimeException("栈中元素为空");
        }
        return data;
    }

    private int top(Queue<Integer> dataQueue, Queue<Integer> emptyQueue) {
        Integer data = null;
        while (!dataQueue.isEmpty()) {
            data = dataQueue.poll();
            emptyQueue.add(data);
        }
        return data;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        用队列实现栈_225 obj = new 用队列实现栈_225();
        obj.push(1);
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
    }

}
