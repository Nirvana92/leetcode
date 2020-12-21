package leetcode.editor.cn;

public class No_142_Circular_Linked_List_II {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        // 慢指针, 快指针
        ListNode slow = head.next, fast = head.next.next;
        while (slow != null && fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast) {
            fast = head;

            while (slow != null && fast != null && slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return fast == slow ? fast : null;
    }
}
