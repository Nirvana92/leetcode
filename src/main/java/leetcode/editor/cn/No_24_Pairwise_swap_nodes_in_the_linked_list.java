package leetcode.editor.cn;

import org.junit.Test;

public class No_24_Pairwise_swap_nodes_in_the_linked_list {
    @Test
    public void test() {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null, preNode = null;
        ListNode firstNode = null, secondHead = null;

        while (head != null && head.next != null) {
            firstNode = head;
            secondHead = head.next;
            // 交换两个链表
            if (newHead == null) {
                newHead = secondHead;
            } else {
                // 前面的节点不为空
                preNode.next = secondHead;
            }

            head = secondHead.next;
            firstNode.next = secondHead.next;
            secondHead.next = firstNode;

            preNode = firstNode;
        }

        return newHead;
    }
}
