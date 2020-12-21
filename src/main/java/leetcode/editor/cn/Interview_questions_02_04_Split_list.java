package leetcode.editor.cn;

import org.junit.Test;

/**
 * 分割链表
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，
 * 其不需要被置于左右两部分之间。
 * <p>
 * 参考: {@link leetcode.editor.cn.No_86_Split_list}
 */
public class Interview_questions_02_04_Split_list {
    @Test
    public void test() {

    }

    public ListNode partition(ListNode head, int x) {
        // 遍历head 将单链表拆分成两个链表, 一个小于x , 一个大于等于x
        ListNode lessStartNode = null, lessEndNode = null;
        ListNode moreStartNode = null, moreEndNode = null;

        ListNode tmpHead = head;
        ListNode nextNode = null;
        while (tmpHead != null) {
            nextNode = tmpHead.next;
            tmpHead.next = null;
            if (tmpHead.val < x) {
                if (lessEndNode == null) {
                    lessStartNode = tmpHead;
                    lessEndNode = tmpHead;
                } else {
                    lessEndNode.next = tmpHead;
                    lessEndNode = tmpHead;
                }
            } else {
                if (moreEndNode == null) {
                    moreStartNode = tmpHead;
                    moreEndNode = tmpHead;
                } else {
                    moreEndNode.next = tmpHead;
                    moreEndNode = tmpHead;
                }
            }

            tmpHead = nextNode;
        }

        if (lessStartNode == null) {
            lessStartNode = moreStartNode;
        } else {
            lessEndNode.next = moreStartNode;
        }

        return lessStartNode;
    }
}
