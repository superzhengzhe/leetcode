package 剑指offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * 1 <= values <= 10000
 * 最多会对appendTail、deleteHead 进行10000次调用
 * @author zz
 * @date 2021/2/1 13:46
 */
public class 用两个栈实现队列 {

    private Stack<Integer> appendStack;

    private Stack<Integer> deleteStack;

    /**
     * 做法：双栈法
     * 一个负责倒入，一个负责倒出
     */
    public 用两个栈实现队列() {
        appendStack = new Stack<>();
        deleteStack = new Stack<>();
    }

    public void appendTail(int value) {
        appendStack.push(value);
    }

    public int deleteHead() {
        if (!deleteStack.isEmpty()) {
            return deleteStack.pop();
        }
        while (!appendStack.isEmpty()) {
            deleteStack.push(appendStack.pop());
        }
        if (!deleteStack.isEmpty()) {
            return deleteStack.pop();
        } else {
            return -1;
        }
    }

}
