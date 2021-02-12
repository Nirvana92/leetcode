package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/1/19 5:36 下午
 * @desc: 1721. 交换链表中的节点
 */
public class No_1721_Exchange_the_nodes_in_the_linked_list {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(3);
        ListNode nnn = new ListNode(4);
        ListNode nnnn = new ListNode(5);
        ListNode nnnnn = new ListNode(6);
        ListNode nnnnnn = new ListNode(7);
        ListNode nnnnnnn = new ListNode(8);
        ListNode nnnnnnnn = new ListNode(9);

        head.next = n;
        n.next = nn;
        nn.next = nnn;
        nnn.next = nnnn;
        nnnn.next = nnnnn;
        nnnnn.next = nnnnnn;
        nnnnnn.next = nnnnnnn;
        nnnnnnn.next = nnnnnnn;
        nnnnnnn.next = nnnnnnnn;

//        ListNode head = new ListNode(1);
//        ListNode n = new ListNode(2);
//        head.next = n;

        int k = 7;

        ListNode listNode = swapNodes(head, k);
        System.out.println(listNode);
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode tmpHead = head;

        int len = getLen(tmpHead);

        // 正序
        // int posiIndex = k;
        // 倒序
        int backIndex = len + 1 - k;
        if (backIndex < k) {
            backIndex = k;
            k = len + 1 - k;
        }

        // 倒序的节点, 倒序的前一个节点
        ListNode posiNode = head, posiPreNode = null;
        ListNode backNode = head, backPreNode = null;
        for (int i = 1; i < backIndex; i++) {
            if (i < k) {
                posiPreNode = posiNode;
                posiNode = posiNode.next;
            }

            backPreNode = backNode;
            backNode = backNode.next;
        }

        if (k == 1) {
            // 需要换头
            if (backPreNode != null) {
                backPreNode.next = posiNode;
            }

            ListNode tmpNextNode = posiNode.next;
            posiNode.next = backNode.next;
            backNode.next = tmpNextNode;
            head = backNode;
        } else if (posiNode != backNode) {
            // 需要交换的节点不是同一个节点
            posiPreNode.next = backNode;
            backPreNode.next = posiNode;

            ListNode tmpNextNode = posiNode.next;
            posiNode.next = backNode.next;
            backNode.next = tmpNextNode;
        }

        return head;
    }

    int getLen(ListNode head) {
        int len = 0;

        while (head != null) {
            head = head.next;
            len++;
        }

        return len;
    }
}
