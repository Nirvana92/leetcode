package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/9 4:16 下午
 * @desc
 */
public class No_234_Palindrome_linked_list {
    @Test
    public void test() {
        // 1->2
//        ListNode root = new ListNode(1);
//        ListNode n = new ListNode(2);
//        ListNode nn = new ListNode(1);
//        root.next = n;
//        n.next = nn;

        // 1->2->2->1
        ListNode root = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(2);
        ListNode nnn = new ListNode(1);
        root.next = n;
        n.next = nn;
        nn.next = nnn;

        boolean palindrome = isPalindrome(root);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode firstNode = head, secondNode = head, preNode = head;
        int len = getLen(head) / 2;
        for (int i = 0; i < len; i++) {
            secondNode = secondNode.next;
            if (i == len - 1) {
                preNode.next = null;
            }
            preNode = secondNode;
        }
        firstNode = head;
        secondNode = reverseList(secondNode);

        ListNode tmpFirstNode = firstNode, tmpSecondNode = secondNode;
        while (tmpFirstNode != null && tmpSecondNode != null) {
            if (tmpFirstNode.val != tmpSecondNode.val) {
                return false;
            }

            tmpFirstNode = tmpFirstNode.next;
            tmpSecondNode = tmpSecondNode.next;
        }

        return Math.max(getLen(tmpFirstNode), getLen(tmpSecondNode)) <= 1;
    }


    /**
     * 获取链表的长度
     *
     * @param node
     * @return
     */
    int getLen(ListNode node) {
        int len = 0;
        ListNode tmpNode = node;
        while (tmpNode != null) {
            len++;
            tmpNode = tmpNode.next;
        }

        return len;
    }

    /**
     * 反转链表, 返回表头节点
     *
     * @param head
     * @return
     */
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
