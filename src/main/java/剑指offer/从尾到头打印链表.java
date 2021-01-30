package 剑指offer;

import base.ListNode;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 * @author zz
 * @date 2021/1/30 16:42
 */
public class 从尾到头打印链表 {

    /**
     * 做法2：遍历
     * 直接遍历，获取链表的长度
     * 然后直接构建一个数组，长度为链表的长度
     * 然后从头遍历链表，将链表的第一个值保存到数组的最后
     * 反过来保存即可
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        int len =  0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        int[] res = new int[len];
        int index = len - 1;
        node = head;
        while (node != null) {
            res[index--] = node.val;
            node = node.next;
        }
        return res;
    }

    /**
     * 做法：使用栈
     * 根据栈先进后出的特性，将链表全部依次压入栈
     * 然后从栈中弹出元素，打印即可
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop().val;
        }
        return res;
    }

}
