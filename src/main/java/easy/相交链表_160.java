package easy;

import base.ListNode;

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 如下面的两个链表：
 * 在节点 c1 开始相交。
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例 2：
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 示例 3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * @author zz
 * @date 2021/1/3 16:17
 */
public class 相交链表_160 {

    /**
     * 做法：空间复杂度o(1)
     * 首先遍历两个链表，计算出长度
     * 然后长的链表先走，假设链表A长度100，链表B长度50，则A先走50步
     * 然后两个链表同时走，如果中间遇到了，那么就说明相交。否则没有相交
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA, nodeB = headB;
        int lengthA = 1, lengthB = 1;
        while (nodeA.next != null) {
            nodeA = nodeA.next;
            lengthA++;
        }
        while (nodeB.next != null) {
            nodeB = nodeB.next;
            lengthB++;
        }
        nodeA = headA;
        nodeB = headB;
        int count = 0;
        if (lengthA > lengthB) {
            count = lengthA - lengthB;
            while (count > 0) {
                nodeA = nodeA.next;
                count--;
            }
        } else if (lengthA < lengthB) {
            count = lengthB - lengthA;
            while (count > 0) {
                nodeB = nodeB.next;
                count--;
            }
        }
        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode nodeA = node1;
        nodeA.next = node3;
        nodeA.next.next = node4;

        ListNode nodeB = node2;
        nodeB.next = node5;
        nodeB.next.next = node3;

        System.out.println(new 相交链表_160().getIntersectionNode(nodeA, nodeB));
    }


}
