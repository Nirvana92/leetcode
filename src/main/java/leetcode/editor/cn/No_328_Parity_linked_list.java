package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/9 5:28 下午
 * @desc: 328. 奇偶链表: 先奇数下标再偶数下标
 */
public class No_328_Parity_linked_list {
    @Test
    public void test() {
        // 1->2->3->4->5->NULL
        // 处理后: 1->3->5->2->4->NULL
//        ListNode root = new ListNode(1);
//        ListNode n = new ListNode(2);
//        ListNode nn = new ListNode(3);
//        ListNode nnn = new ListNode(4);
//        ListNode nnnn = new ListNode(5);
//        root.next = n;
//        n.next = nn;
//        nn.next = nnn;
//        nnn.next = nnnn;

        // 2->1->3->5->6->4->7->NULL
        // 处理后: 2->3->6->7->1->5->4->NULL
//        ListNode root = new ListNode(2);
//        ListNode n = new ListNode(1);
//        ListNode nn = new ListNode(3);
//        ListNode nnn = new ListNode(5);
//        ListNode nnnn = new ListNode(6);
//        ListNode nnnnn = new ListNode(4);
//        ListNode nnnnnn = new ListNode(7);
//        root.next = n;
//        n.next = nn;
//        nn.next = nnn;
//        nnn.next = nnnn;
//        nnnn.next = nnnnn;
//        nnnnn.next = nnnnnn;

        ListNode root = new ListNode(2);
        ListNode n = new ListNode(1);
//        ListNode nn = new ListNode(3);
        root.next = n;
//        n.next = nn;

        ListNode oddEvenList = oddEvenList(root);
        System.out.println(oddEvenList);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        // 偶数节点的开始节点和结束节点
        ListNode evenStartNode = null, evenEndNode = null;
        // 奇数节点的开始节点和结束节点
        ListNode oddStartNode = null, oddEndNode = null;

        boolean isOdd = true;
        while (head != null) {
            if (isOdd) {
                // 奇数节点
                if (oddStartNode == null) {
                    oddStartNode = head;
                    oddEndNode = head;
                } else {
                    oddEndNode.next = head;
                    oddEndNode = head;
                }
            } else {
                // 偶数节点
                if (evenStartNode == null) {
                    evenStartNode = head;
                    evenEndNode = head;
                } else {
                    evenEndNode.next = head;
                    evenEndNode = head;
                }
            }
            isOdd = !isOdd;
            head = head.next;
        }

        // 清空end 节点
        oddEndNode.next = null;
        evenEndNode.next = null;

        if (oddEndNode == null) {
            oddStartNode = evenStartNode;
        } else {
            oddEndNode.next = evenStartNode;
        }

        return oddStartNode;
    }
}
