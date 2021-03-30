package 链表.简单;

import base.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * @author zz
 */
public class 合并两个有序链表_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode resNode = null;
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode res = resNode;
        while (node1 != null || node2 != null) {
            if (resNode == null) {
                resNode = new ListNode();
                res = resNode;
            } else {
                res.next = new ListNode();
                res = res.next;
            }
            if (node1 == null) {
                res.val = node2.val;
                node2 = node2.next;
                continue;
            }
            if (node2 == null) {
                res.val = node1.val;
                node1 = node1.next;
                continue;
            }
            if (node1.val > node2.val) {
                res.val = node2.val;
                node2 = node2.next;
            } else {
                res.val = node1.val;
                node1 = node1.next;
            }
        }
        return resNode;
    }

}
