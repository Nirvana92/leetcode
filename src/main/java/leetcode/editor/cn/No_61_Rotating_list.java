package leetcode.editor.cn;

import org.junit.Test;

public class No_61_Rotating_list {
    @Test
    public void test() {
        ListNode root = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(3);
        ListNode nnn = new ListNode(4);
        ListNode nnnn = new ListNode(5);
        root.next = n;
        n.next = nn;
        nn.next = nnn;
        nnn.next = nnnn;

        int k = 2;
        ListNode listNode = rotateRight(root, k);
        System.out.println(listNode);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 计算链表的总长度
        ListNode tmpHead = head, lastNode = null, newHead = head;
        int len = 0;
        while (tmpHead != null) {
            tmpHead = tmpHead.next;
            len++;

            if (lastNode == null && tmpHead.next == null) {
                // 最后一个节点
                lastNode = tmpHead;
            }
        }

        k = k % len;

        // 将lastNode 的下一个指针指向头结点
        lastNode.next = head;

        // 然后从 head 往下遍历, 找到第k 个元素为新的头结点
        int moveStep = len - k;
        while (moveStep-- > 0) {
            newHead = newHead.next;
        }

        // 然后从新的头结点往下遍历找到第 len 节点, 让后将第len节点的next 设置为空
        tmpHead = newHead;
        while (--len > 0) {
            tmpHead = tmpHead.next;
        }

        if (tmpHead != null) {
            tmpHead.next = null;
        }

        return newHead;
    }
}
