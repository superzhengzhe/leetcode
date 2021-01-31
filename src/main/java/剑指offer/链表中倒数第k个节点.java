package 剑指offer;

import base.ListNode;

/**
 * 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * @author zz
 * @date 2021/1/31 15:43
 */
public class 链表中倒数第k个节点 {

    /**
     * 做法：快慢指针
     * 只需要遍历一次，定义快慢两个指针
     * 快指针先走k-1步，然后快慢指针同时走
     * 如果快指针的下一步为空，慢指针即可所求
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        for (int i = 1;i < k;i++) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 做法：两次遍历
     * 第一次遍历，求出链表的长度len
     * 第二次遍历，第(len - k + 1)的节点即为所求
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            len++;
        }
        int index = 1;
        node = head;
        while (index != len - k + 1) {
            index++;
            node = node.next;
        }
        return node;
    }

}
