package 剑指offer;

import base.ListNode;

/**
 * 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * 说明：
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * @author zz
 * @date 2021/1/30 17:19
 */
public class 删除链表的节点 {

    /**
     * 做法：node.next = node.next.next
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            if (head.next != null) {
                return head.next;
            } else {
                return null;
            }
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == val) {
                if (node.next.next != null) {
                    node.next = node.next.next;
                } else {
                    node.next = null;
                }
                return head;
            }
            node = node.next;
        }
        return head;
    }

}
