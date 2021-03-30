package 链表.简单;

import base.ListNode;

/**
 * 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * @author zz
 * @date 2020/12/14 10:52
 */
public class 删除排序链表中的重复元素_83 {

    /**
     * 做法
     * 两个链表标志位，一个值标准位
     * 遇到一样的就删除，否则链表向前走
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode node = head.next;
        int val = 0;
        while (node != null) {
            val = pre.val;
            if (node.val == val) {
                pre.next = node.next;
            } else {
                pre = pre.next;
            }
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        System.out.println(new 删除排序链表中的重复元素_83().deleteDuplicates(listNode1));

        listNode1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        System.out.println(new 删除排序链表中的重复元素_83().deleteDuplicates(listNode1));
    }

}
