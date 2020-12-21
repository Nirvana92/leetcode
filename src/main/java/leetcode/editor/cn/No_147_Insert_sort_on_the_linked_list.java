package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/20 11:24 上午
 * @desc: 147. 对链表进行插入排序
 */
public class No_147_Insert_sort_on_the_linked_list {
    @Test
    public void test() {
//        ListNode root = new ListNode(4);
//        ListNode n = new ListNode(2);
//        ListNode nn = new ListNode(1);
//        ListNode nnn = new ListNode(3);
//
//        root.next = n;
//        n.next = nn;
//        nn.next = nnn;

//        ListNode root = new ListNode(-1);
//        ListNode n = new ListNode(5);
//        ListNode nn = new ListNode(3);
//        ListNode nnn = new ListNode(4);
//        ListNode nnnn = new ListNode(0);
//
//        root.next = n;
//        n.next = nn;
//        nn.next = nnn;
//        nnn.next = nnnn;

//        ListNode root = new ListNode(1);
//        ListNode n = new ListNode(2);
//        ListNode nn = new ListNode(3);
//        ListNode nnn = new ListNode(4);
//        root.next = n;
//        n.next = nn;
//        nn.next = nnn;


        ListNode root = new ListNode(1);
        ListNode n = new ListNode(0);
        root.next = n;


        ListNode listNode = insertionSortList(root);
        System.out.println(listNode);


    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curNode = head, firstNode = head, curNextNode = null, curPreFirstNode = null, curFirstNode = null;

        while (curNode.next != null) {
            curNextNode = curNode.next;

            if (curNextNode.val > curNode.val) {
                // 不需要往前遍历
                curNode = curNode.next;
            } else {
                // 需要从头开始遍历
                curFirstNode = firstNode;
                if (curNextNode.val <= curFirstNode.val) {
                    // 新插入的是新的头结点
                    curNode.next = curNextNode.next;
                    curNextNode.next = curFirstNode;
                    firstNode = curNextNode;
                } else {
                    // 否在在头结点和尾节点中间位置
                    while (curNextNode.val > curFirstNode.val) {
                        curPreFirstNode = curFirstNode;
                        curFirstNode = curFirstNode.next;
                    }

                    // 新插入的是中间位置
                    curPreFirstNode.next = curNextNode;
                    curNode.next = curNextNode.next;
                    curNextNode.next = curFirstNode;

                }
            }
        }

        return firstNode;
    }
}
