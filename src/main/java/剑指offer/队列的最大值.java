package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value需要返回 -1
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出:[null,null,null,2,1,2]
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出:[null,-1,-1]
 * 限制：
 * 1 <= push_back,pop_front,max_value的总操作数<= 10000
 * 1 <= value <= 10^5
 * @author zz
 * @date 2021/2/1 15:55
 */
public class 队列的最大值 {

    private Queue<Integer> dataQueue;

    private Deque<Integer> maxQueue;

    /**
     * 做法：两个队列
     * 一个队列正常操作
     * 另一个队列维护最值，该队列为双端队列。每次push时，从底部push，且push前会把所有比他小的值都取出来。poll时直接从对头拿即为最大值
     */
    public 队列的最大值() {
        this.dataQueue = new ArrayDeque<>();
        this.maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        dataQueue.add(value);
        if (maxQueue.isEmpty()) {
            maxQueue.addLast(value);
        } else {
            Integer last = maxQueue.peekLast();
            while (last != null && last <= value) {
                maxQueue.pollLast();
                last = maxQueue.peekLast();
            }
            maxQueue.addLast(value);
        }
    }

    public int pop_front() {
        if (dataQueue.isEmpty()) {
            return -1;
        }
        Integer result = dataQueue.poll();
        if (!maxQueue.isEmpty() && maxQueue.peekFirst().equals(result)) {
            maxQueue.pollFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        队列的最大值 queue = new 队列的最大值();
        queue.push_back(1);
        queue.push_back(2);
        System.out.println(queue.max_value());
    }

}
