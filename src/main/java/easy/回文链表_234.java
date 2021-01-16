package easy;

import base.ListNode;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @author zz
 * @date 2021/1/17 0:35
 */
public class 回文链表_234 {

    /**
     * 做法：时间复杂度o(n)，空间复杂度o(1)
     * 1. 使用快慢指针遍历链表，当快指针走到最尾的时候，慢指针就是中间点
     * 2. 从中间点开始，反转左边的链表
     * 3. 从中间点左右开始比较链表是否相同
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == slow) {
            if (head.val == head.next.val) {
                return true;
            }
            return false;
        }

        ListNode mid = slow, left, right;
        if (fast.next != null) {
            slow = slow.next;
            right = slow;
        } else {
            right = slow.next;
        }
        ListNode pre = head, node = head.next, tmp;
        pre.next = null;
        while (node != slow) {
            tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }

        left = pre;
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        if (left == null && right == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(0));
        System.out.println(new 回文链表_234().isPalindrome(head));

        head = new ListNode(1, new ListNode(2, new ListNode(1)));
        System.out.println(new 回文链表_234().isPalindrome(head));

        head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(new 回文链表_234().isPalindrome(head));
    }

}
