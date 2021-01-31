package 剑指offer;

import base.ListNode;

/**
 * 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 限制：
 * 0 <= 节点个数 <= 5000
 * @author zz
 * @date 2021/1/31 16:10
 */
public class 反转链表 {

    /**
     * 做法：遍历
     * 采用两个变量pre，node
     * pre指向上一个节点，node指向当前节点
     * 不断遍历链表，然后令node.next = pre, pre = node, node = 下一个节点
     * 当node为空时，pre即为所求
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode node = head.next;
        ListNode tmp = null;
        pre.next = null;
        while (node != null) {
            tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }
        return pre;
    }

}
