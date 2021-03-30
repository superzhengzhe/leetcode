package 链表.简单;

import base.ListNode;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * @author zz
 */
public class 两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode resultListNode = new ListNode();
        int len1 = 1, len2 = 1;

        ListNode node = l1;
        while (node.next != null) {
            len1++;
            node = node.next;
        }
        node = l2;
        while (node.next != null) {
            len2++;
            node = node.next;
        }

        node = l1;
        ListNode node1 = l1;
        ListNode node2 = l2;
        int len = Math.max(len1, len2);
        if (len == len2) {
            node = l2;
        }

        int carry = 0;
        ListNode next = resultListNode;
        next.val = node1.val + node2.val + carry;
        carry = next.val / 10;
        next.val = next.val % 10;
        while (node.next != null) {
            ListNode listNode = new ListNode();
            if (node1.next != null) {
                node1 = node1.next;
                listNode.val += node1.val;
            }
            if (node2.next != null) {
                node2 = node2.next;
                listNode.val += node2.val;
            }
            listNode.val += carry;
            carry = listNode.val / 10;
            listNode.val = listNode.val % 10;
            next.next = listNode;
            node = node.next;
            next = next.next;
        }
        if (carry == 1) {
            ListNode listNode = new ListNode();
            listNode.val = 1;
            next.next = listNode;
        }
        return resultListNode;
    }

}
