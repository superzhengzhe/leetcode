package 链表;

import base.ListNode;

/**
 * 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @author zz
 * @date 2021/1/8 17:58
 */
public class 移除链表元素_203 {

    /**
     * 做法：删除链表的核心，node.next = node.next.next
     * 本题有两个点，一个是遍历去查找等于val值的元素，另一个要注意对头节点的特殊处理
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (node.next != null) {
           if (node.next.val == val) {
               node.next = node.next.next;
           } else {
               node = node.next;
           }
        }
        return head;
    }

}
