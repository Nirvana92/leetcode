package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/29 7:00 下午
 * @desc: 83. 删除排序链表中的重复元素
 */
public class No_83_Delete_duplicate_elements_in_the_sorted_list {
    @Test
    public void test() {
        // 1->1->2
        ListNode head = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(2);
        // ListNode nnn = new ListNode(2);
        ListNode nnnn = new ListNode(3);
        // ListNode nnnnn = new ListNode(3);
        head.next = n;
        n.next = nn;
        nn.next = nnnn;
        // nn.next = nnn;
        // nnn.next = nnnn;
        // nnnn.next = nnnnn;

        ListNode listNode = deleteDuplicates(head);
        System.out.println(listNode);

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode tmpHead = head;

        while (tmpHead != null && tmpHead.next != null) {
            ListNode nextNode = tmpHead.next;
            while (nextNode != null && tmpHead.val == nextNode.val) {
                nextNode = nextNode.next;
            }

            tmpHead.next = nextNode;
            tmpHead = nextNode;
        }

        return head;
    }
}
