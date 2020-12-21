package leetcode.editor.cn;

import org.junit.Test;

public class No_143_Rearranged_list {
    @Test
    public void test() {
        ListNode root = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(3);
        ListNode nnn = new ListNode(4);
        ListNode nnnn = new ListNode(5);
//        ListNode nnnnn = new ListNode(6);
//        ListNode nnnnnn = new ListNode(7);
        root.next = n;
        n.next = nn;
        nn.next = nnn;
        nnn.next = nnnn;
//        nnnn.next = nnnnn;
//        nnnnn.next = nnnnnn;

        reorderList(root);
        System.out.println(root);

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode tmpNode = head;
        int nodeLen = getListNodeLen(tmpNode);
        int flipNodeLen = nodeLen / 2;
        tmpNode = head;

        // 1 -> 2-> 3-> 4-> 5
        for (int i = 0; i < flipNodeLen; i++) {
            tmpNode = tmpNode.next;
        }

        // 从中间位置开始翻转链表, 即tmpNode 的位置
        ListNode nextNode = tmpNode.next.next, curNode = tmpNode.next, preNode = tmpNode;
        tmpNode.next = null;
        while (curNode != null) {
            curNode.next = preNode;
            preNode = curNode;

            curNode = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }

        // 开始重排链表
        tmpNode = head;
        ListNode tailNode = preNode, headNext = null, tailNext = null;

        while (tailNode != null && tmpNode != tailNode && tailNode != tmpNode.next) {
            headNext = tmpNode.next;
            tailNext = tailNode.next;

            tmpNode.next = tailNode;
            tailNode.next = headNext;

            // 往下移动
            tmpNode = headNext;
            tailNode = tailNext;
        }
    }

    int getListNodeLen(ListNode head) {
        int nodeLen = 0;
        while (head != null) {
            nodeLen++;
            head = head.next;
        }

        return nodeLen;
    }
}
