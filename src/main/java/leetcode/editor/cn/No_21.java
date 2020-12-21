package leetcode.editor.cn;

import org.junit.Test;

/**
 * 21. 合并两个有序链表
 */
public class No_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode head = l1.val > l2.val ? l2 : l1;
        if(head == l1) {
            l1 = l1.next;
        }else {
            l2 = l2.next;
        }
        ListNode pre = head;
        while (l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                // 将l2 加到head 中
                pre.next = l2;
                l2 = l2.next;
            }else {
                // 将l1 加到head 中
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }

        while (l1 != null) {
            pre.next = l1;
            l1 = l1.next;
            pre = pre.next;
        }

        while (l2 != null) {
            pre.next = l2;
            l2 = l2.next;
            pre = pre.next;
        }

        return head;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        l1_1.next = l1_2;
        l1.next = l1_1;

        ListNode l2 = new ListNode(1);
        ListNode l2_1 = new ListNode(3);
        ListNode l2_2 = new ListNode(4);
        l2_1.next = l2_2;
        l2.next = l2_1;

        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }
}
