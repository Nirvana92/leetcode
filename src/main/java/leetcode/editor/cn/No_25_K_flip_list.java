package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/27 9:58 上午
 * @desc: 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class No_25_K_flip_list {
    @Test
    public void test() {
        // 1->2->3->4->5

        // 当 k = 2 时，应当返回: 2->1->4->3->5
        // 当 k = 3 时，应当返回: 3->2->1->4->5
        ListNode root = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(3);
        ListNode nnn = new ListNode(4);
        ListNode nnnn = new ListNode(5);

        root.next = n;
        n.next = nn;
        nn.next = nnn;
        nnn.next = nnnn;

        int k = 3;

        ListNode listNode = reverseKGroup(root, k);
        System.out.println(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode flipFirstNode = null, flipEndNode = null;
        ListNode willFlipFirstNode = null, willFlipEndNode = null;
        ListNode nextNode = null;

        while (head != null) {
            int nodeCounts = 0;
            for (int i = 0; i < k && head != null; i++) {
                nextNode = head.next;
                head.next = null;
                nodeCounts++;
                if (willFlipFirstNode == null) {
                    willFlipFirstNode = head;
                    willFlipEndNode = head;
                } else {
                    willFlipEndNode.next = head;
                    willFlipEndNode = head;
                }

                head = nextNode;
            }

            if (nodeCounts == k) {
                // 翻转
                ListNode[] listNodes = reverseList(willFlipFirstNode);
                willFlipFirstNode = listNodes[0];
                willFlipEndNode = listNodes[1];
            } else {
                // 不等于k, 说明已经到结尾, 并且不够k个节点, 不需要翻转
            }

            if (flipFirstNode == null) {
                flipFirstNode = willFlipFirstNode;
                flipEndNode = willFlipEndNode;
            } else {
                flipEndNode.next = willFlipFirstNode;
                flipEndNode = willFlipEndNode;
            }

            willFlipFirstNode = null;
            willFlipEndNode = null;
        }

        return flipFirstNode;
    }

    /**
     * [0]: startNode
     * [1]: endNode
     *
     * @param head
     * @return
     */
    public ListNode[] reverseList(ListNode head) {
        if (head == null) {
            return new ListNode[]{head, head};
        }

        ListNode endNode = head;
        ListNode preNode = null, nextNode = head.next;
        while (nextNode != null) {
            nextNode = head.next;
            head.next = preNode;

            preNode = head;
            if (nextNode != null) {
                head = nextNode;
            }
        }

        return new ListNode[]{head, endNode};
    }
}
