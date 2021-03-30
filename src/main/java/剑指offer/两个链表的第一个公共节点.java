package 剑指offer;

import base.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * 如下面的两个链表：
 * 在节点 c1 开始相交。
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例2：
 * 输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 示例3：
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
 * @date 2021/1/31 17:16
 */
public class 两个链表的第一个公共节点 {

    /**
     * 做法：遍历
     * 先计算出两个链表的长度
     * 然后长的先走n步(长链表-短链表的长度的步数)
     * 然后两个链表同时走，如果值相等即为所求，否则没有交点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        int lenA = 1;
        while (nodeA != null) {
            nodeA = nodeA.next;
            lenA++;
        }
        ListNode nodeB = headB;
        int lenB = 1;
        while (nodeB != null) {
            nodeB = nodeB.next;
            lenB++;
        }

        nodeA = headA;
        nodeB = headB;
        int step = 0;
        if (lenA > lenB) {
            step = lenA - lenB;
            while (step != 0) {
                nodeA = nodeA.next;
                step--;
            }
        } else {
            step = lenB - lenA;
            while (step != 0) {
                nodeB = nodeB.next;
                step--;
            }
        }

        while (nodeA != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

}
