package leetcode.editor.cn;

import org.junit.Test;

public class No_445_Add_two_numbers_II {
    @Test
    public void testReverseListNode() {
        ListNode root = new ListNode(1);
        ListNode n = new ListNode(2);
//        ListNode nn = new ListNode(3);
        root.next = n;
//        n.next = nn;
        ListNode listNode = reverseListNode(root);
        System.out.println(listNode);
    }

    /**
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     */
    @Test
    public void test() {
        ListNode l1 = new ListNode(7);
        ListNode l1n = new ListNode(2);
        ListNode l1nn = new ListNode(4);
        ListNode l1nnn = new ListNode(3);

        l1.next = l1n;
        l1n.next = l1nn;
        l1nn.next = l1nnn;

        ListNode l2 = new ListNode(5);
        ListNode l2n = new ListNode(6);
        ListNode l2nn = new ListNode(4);
        l2.next = l2n;
        l2n.next = l2nn;

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

//        ListNode tmpL1 = reverseListNode(l1);
//        ListNode tmpL2 = reverseListNode(l2);
        ListNode tmpL1 = l1, tmpL2 = l2;

        // 相加操作
        ListNode resultNode = null, tmpNode = null;
        // 进位值
        int carryVal = 0, sum = 0;
        while (tmpL1 != null && tmpL2 != null) {
            sum = tmpL1.val + tmpL2.val + carryVal;

            if (resultNode == null) {
                resultNode = new ListNode(sum % 10);
                carryVal = sum / 10;
            } else {
                tmpNode = new ListNode(sum % 10);
                carryVal = sum / 10;
                tmpNode.next = resultNode;
                resultNode = tmpNode;
            }

            tmpL1 = tmpL1.next;
            tmpL2 = tmpL2.next;
        }

        while (tmpL1 != null) {
            sum = tmpL1.val + carryVal;

            tmpNode = new ListNode(sum % 10);
            carryVal = sum / 10;
            tmpNode.next = resultNode;
            resultNode = tmpNode;

            tmpL1 = tmpL1.next;
        }

        while (tmpL2 != null) {
            sum = tmpL2.val + carryVal;

            tmpNode = new ListNode(sum % 10);
            carryVal = sum / 10;
            tmpNode.next = resultNode;
            resultNode = tmpNode;

            tmpL2 = tmpL2.next;
        }

        if (carryVal > 0) {
            tmpNode = new ListNode(carryVal);
            tmpNode.next = resultNode;
            resultNode = tmpNode;
        }

        // 还原给出的参数
        reverseListNode(l1);
        reverseListNode(l2);
        reverseListNode(resultNode);

        return resultNode;
    }

    /**
     * 反转链表
     *
     * @param node
     * @return
     */
    ListNode reverseListNode(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode next = node.next;
        node.next = null;
        while (next != null) {
            // 相对node而言是下下一个节点
            ListNode nnext = next.next;

            next.next = node;
            node = next;
            next = nnext;
        }

        return node;
    }
}
