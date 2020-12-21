package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/9 3:47 下午
 * @desc
 */
public class No_19 {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        ListNode next4 = new ListNode(5);
        next3.next = next4;
        next2.next = next3;
        next1.next = next2;
        head.next = next1;

        ListNode listNode = removeNthFromEnd(head, 6);
        System.out.println(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sumLen = 0;
        ListNode tmpNode = head;
        // 计算链表总长度
        while (tmpNode != null) {
            sumLen++;
            tmpNode = tmpNode.next;
        }

        // 需要删除的节点前一个下标值下标值: 需要删除的下标值从 1 开始
        int waitDelPreIndex = sumLen - n;
        if (waitDelPreIndex <= 0) {
            return head.next;
        }
        tmpNode = head;
        // 重新遍历, 并找到 waitDelIndex 的前一个节点, 然后删除后一个节点
        while (--waitDelPreIndex > 0) {
            tmpNode = tmpNode.next;
        }

        tmpNode.next = tmpNode.next.next;

        return head;
    }


}
