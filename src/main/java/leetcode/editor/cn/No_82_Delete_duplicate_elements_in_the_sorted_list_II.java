package leetcode.editor.cn;

import org.junit.Test;

public class No_82_Delete_duplicate_elements_in_the_sorted_list_II {
    @Test
    public void test() {
        ListNode root = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(3);
        ListNode nnn = new ListNode(3);
        ListNode nnnn = new ListNode(4);
        ListNode nnnnn = new ListNode(4);
        ListNode nnnnnn = new ListNode(5);

        root.next = n;
        n.next = nn;
        nn.next = nnn;
        nnn.next = nnnn;
        nnnn.next = nnnnn;
        nnnnn.next = nnnnnn;

        ListNode node = deleteDuplicates(root);
        System.out.println(node);
    }

    /***
     * 参考的评论区中的答案, 通过递归的思想处理该问题
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head != null && head.next != null && head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }

            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
