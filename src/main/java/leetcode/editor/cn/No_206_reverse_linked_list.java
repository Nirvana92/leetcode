package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/22 5:03 下午
 * @desc
 */
public class No_206_reverse_linked_list {
    @Test
    public void test() {
        ListNode root = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(3);
        ListNode nnn = new ListNode(4);
        ListNode nnnn = new ListNode(5);
        nnn.next = nnnn;
        nn.next = nnn;
        n.next = nn;
        root.next = n;

        ListNode reverseNode = reverseList(root);
        System.out.println(reverseNode);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode preNode = null, nextNode = head.next;
        while (nextNode != null) {
            nextNode = head.next;
            head.next = preNode;

            preNode = head;
            if (nextNode != null) {
                head = nextNode;
            }
        }

        return head;
    }
}
