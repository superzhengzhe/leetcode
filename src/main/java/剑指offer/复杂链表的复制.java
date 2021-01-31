package 剑指offer;

import base.Node;

/**
 * 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * 提示：
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * @author zz
 * @date 2021/1/31 16:30
 */
public class 复杂链表的复制 {

    /**
     * 做法：遍历
     * 先遍历一遍链表，每遍历一个节点，就拷贝一个节点，并插在当前节点的后面
     * 再遍历一次链表，这次将链表拷贝节点的random值指向被拷贝节点的random值的下一个节点
     * 最后将链表分拆出来即可
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        while (node != null) {
            Node copyNode = new Node(node.val);
            copyNode.next = node.next;
            node.next = copyNode;
            node = copyNode.next;
        }

        Node nextNode = null;
        node = head;
        while (node != null) {
            nextNode = node.next;
            if(node.random == null) {
                nextNode.random = null;
            } else {
                nextNode.random = node.random.next;
            }
            node = nextNode.next;
        }

        Node res = head.next;
        nextNode = res;
        node = head;
        while (node != null) {
            node.next = nextNode.next;
            if (nextNode.next != null) {
                nextNode.next = nextNode.next.next;
            }
            node = node.next;
            if (nextNode.next != null) {
                nextNode = nextNode.next;
            }
        }
        return res;
    }

}
