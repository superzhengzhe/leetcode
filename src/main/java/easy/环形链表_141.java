package easy;

import base.ListNode;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * 提示：
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 * @author zz
 * @date 2021/1/1 23:25
 */
public class 环形链表_141 {

    /**
     * 做法：快慢指针
     * 快指针一次走两步，慢指针一次走一步
     * 如果两个指针相遇，证明有环。如果走到链表尾部还没有相遇，证明无环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode low = head;
        while (fast != null) {
            if (fast == low) {
                return true;
            }
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            low = low.next;
        }
        return false;
    }

}
