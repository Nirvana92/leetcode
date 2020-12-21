package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/3 5:49 下午
 * @desc: 1669. 合并两个链表
 */
public class No_1669_Merge_two_linked_lists {
    @Test
    public void test() {
        ListNode list1 = new ListNode(0);
        ListNode n = new ListNode(1);
        ListNode nn = new ListNode(2);
        ListNode nnn = new ListNode(3);
        ListNode nnnn = new ListNode(4);
        ListNode nnnnn = new ListNode(5);
        list1.next = n;
        n.next = nn;
        nn.next = nnn;
        nnn.next = nnnn;
        nnnn.next = nnnnn;
//        ListNode nnnnnn = new ListNode(6);
//        ListNode nnnnnnn = new ListNode(7);


        int a = 1, b = 4;
        ListNode list2 = new ListNode(1000000);
        ListNode _2n = new ListNode(1000001);
        ListNode _2nn = new ListNode(1000002);
        list2.next = _2n;
        _2n.next = _2nn;

        ListNode retNode = mergeInBetween(list1, a, b, list2);
        System.out.println(retNode);
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null) {
            return list1;
        }

        if (a == 0) {
            // 换头
            for (int i = 0; i <= b; i++) {
                list1 = list1.next;
            }

            if (list2 != null) {
                ListNode head = list2;

                while (list2.next != null) {
                    list2 = list2.next;
                }
                list2.next = list1;
            }
            return list1;
        } else {
            // 不换头的代码
            ListNode head = list1, firstSegNode = list1, secondSegNode = firstSegNode;

            // list1 被分割的第一段
            for (int i = 0; i < a - 1; i++) {
                firstSegNode = firstSegNode.next;
                secondSegNode = firstSegNode;
            }

            // list1 被分割的第二段
            for (int i = 0; i <= b - a + 1; i++) {
                secondSegNode = secondSegNode.next;
            }

            if (list2 == null) {
                firstSegNode.next = secondSegNode;
            } else {
                firstSegNode.next = list2;
                while (list2.next != null) {
                    list2 = list2.next;
                }

                list2.next = secondSegNode;
            }

            return head;
        }
    }
}
