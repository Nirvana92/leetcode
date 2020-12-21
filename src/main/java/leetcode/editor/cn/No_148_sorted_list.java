package leetcode.editor.cn;

import org.junit.Test;

/**
 * 148. 排序链表
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class No_148_sorted_list {
    @Test
    public void test() {
        // 4->2->1->3
        ListNode root = new ListNode(4);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(1);
        ListNode nnn = new ListNode(3);
        root.next = n;
        n.next = nn;
        nn.next = nnn;

        root = new ListNode(-1);
        n = new ListNode(5);
        nn = new ListNode(3);
        nnn = new ListNode(4);
        ListNode nnnn = new ListNode(0);
        root.next = n;
        n.next = nn;
        nn.next = nnn;
        nnn.next = nnnn;

        root = new ListNode(1);
        n = new ListNode(0);
        root.next = n;

        ListNode listNode = sortList(root);
        System.out.println(listNode);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstNode = null, secondNode = head, preNode = head;
        int len = getLen(head) / 2;
        for (int i = 0; i < len; i++) {
            secondNode = secondNode.next;
            if (i == len - 1) {
                preNode.next = null;
            }
            preNode = secondNode;
        }
        firstNode = head;

        ListNode node1 = sortList(firstNode);
        ListNode node2 = sortList(secondNode);

        return mergeNode(node1, node2);
    }

    int getLen(ListNode node) {
        int len = 0;
        ListNode tmpNode = node;
        while (tmpNode != null) {
            len++;
            tmpNode = tmpNode.next;
        }

        return len;
    }

    ListNode mergeNode(ListNode lNode, ListNode rNode) {
        if (lNode == null && rNode == null) {
            return null;
        }

        if (lNode == null) {
            return rNode;
        }

        if (rNode == null) {
            return lNode;
        }

        ListNode mNode = null, curNode = null;
        while (lNode != null && rNode != null) {
            if (lNode.val > rNode.val) {
                if (curNode == null) {
                    curNode = rNode;
                    mNode = curNode;
                } else {
                    curNode.next = rNode;
                    curNode = curNode.next;
                }
                rNode = rNode.next;
            } else {
                if (curNode == null) {
                    curNode = lNode;
                    mNode = curNode;
                } else {
                    curNode.next = lNode;
                    curNode = curNode.next;
                }
                lNode = lNode.next;
            }
        }

        while (lNode != null) {
            curNode.next = lNode;
            curNode = curNode.next;
            lNode = lNode.next;
        }

        while (rNode != null) {
            curNode.next = rNode;
            curNode = curNode.next;
            rNode = rNode.next;
        }

        return mNode;
    }
}