package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/26 11:14 上午
 * @desc: 86. 分隔链表
 * <p>
 * 类同: leetcode.editor.cn.Interview_questions_02_04_Split_list
 */
public class No_86_Split_list {
    @Test
    public void test() {
        // head = 1->4->3->2->5->2, x = 3
        ListNode head = new ListNode(1);
        ListNode n = new ListNode(4);
        head.next = n;
        ListNode nn = new ListNode(3);
        n.next = nn;
        ListNode nnn = new ListNode(2);
        nn.next = nnn;
        ListNode nnnn = new ListNode(5);
        nnn.next = nnnn;
        ListNode nnnnn = new ListNode(2);
        nnnn.next = nnnnn;
        int x = 3;

        ListNode partition = partition(head, x);
        System.out.println(partition);
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
