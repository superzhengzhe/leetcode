package 栈.简单;

import java.util.Stack;

/**
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 示例:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 提示：
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * 通过次数189,052提交次数338,049
 * @author zz
 * @date 2021/1/3 1:47
 */
public class 最小栈_155 {

    private Stack<Integer> stackData;

    private Stack<Integer> stackMin;

    /**
     * 做法：两个栈
     * 一个跟正常栈一样
     * 另一个只放最小值，就是比小于等于当前栈顶的元素就放进去，弹出来的时候最小值才弹
     */
    public 最小栈_155() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        stackData.push(x);
        if (stackMin.isEmpty()) {
            stackMin.push(x);
            return;
        }
        Integer data = stackMin.peek();
        if (data >= x) {
            stackMin.push(x);
        }
    }

    public void pop() {
        if (!stackData.isEmpty()) {
            int data = stackData.pop();
            if (!stackMin.isEmpty() && stackMin.peek() == data) {
                stackMin.pop();
            }
        } else {
            throw new RuntimeException("栈中元素为空");
        }
    }

    public int top() {
        if (!stackMin.isEmpty()) {
            return stackData.peek();
        }
        throw new RuntimeException("栈中元素为空");
    }

    public int getMin() {
        if (!stackMin.isEmpty()) {
            return stackMin.peek();
        }
        throw new RuntimeException("栈中元素为空");
    }

    public static void main(String[] args) {
        最小栈_155 obj = new 最小栈_155();
        obj.push(5);
        obj.pop();
        int data1 = obj.top();
        System.out.println(data1);
        int data2 = obj.getMin();
        System.out.println(data2);
    }

}
