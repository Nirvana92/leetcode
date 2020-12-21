package leetcode.editor.cn;

import org.junit.Test;

public class No_141 {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(0);
        ListNode nnn = new ListNode(-4);
        head.next = n;
        n.next = nn;
        nn.next = nnn;
        nnn.next = n;
        boolean result = hasCycle(head);
        System.out.println(result);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fastNode = head, slowNode = head;
        fastNode = head.next;

        while (fastNode != null && fastNode.next != null && fastNode != slowNode) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        return fastNode == slowNode;
    }
}
