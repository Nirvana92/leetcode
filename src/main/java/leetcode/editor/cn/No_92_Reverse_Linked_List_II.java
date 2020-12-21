package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/26 2:24 下午
 * @desc: 92. 反转链表 II
 * <p>
 * <p>
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 */
public class No_92_Reverse_Linked_List_II {
    @Test
    public void test() {
        // 1->2->3->4->5->NULL, m = 2, n = 4
        ListNode head = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(3);
        ListNode nnn = new ListNode(4);
        ListNode nnnn = new ListNode(5);
        head.next = n;
        n.next = nn;
        nn.next = nnn;
        nnn.next = nnnn;

        int mIndex = 1, nIndex = 4;
        ListNode reverseBetween = reverseBetween(head, mIndex, nIndex);
        System.out.println(reverseBetween);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode firstStartNode = null, firstEndNode = null;
        ListNode lastStartNode = null, lastEndNode = null;
        ListNode reverseNode = null, reverseEndNode = null;
        ListNode nextNode = null;

        int curIndex = 1;
        while (head != null) {
            nextNode = head.next;
            head.next = null;

            if (curIndex < m) {
                // 开头段
                if (firstStartNode == null) {
                    firstStartNode = head;
                    firstEndNode = head;
                } else {
                    firstEndNode.next = head;
                    firstEndNode = head;
                }
            } else if (curIndex >= m && curIndex <= n) {
                // 放在需要翻转的链表中
                if (reverseNode == null) {
                    reverseNode = head;
                    reverseEndNode = head;
                } else {
                    reverseEndNode.next = head;
                    reverseEndNode = head;
                }
            } else {
                // 末尾段
                if (lastStartNode == null) {
                    lastStartNode = head;
                    lastEndNode = head;
                } else {
                    lastEndNode.next = head;
                    lastEndNode = head;
                }
            }

            head = nextNode;
            curIndex++;
        }

        // 反转
        ListNode[] reverseRsts = reverseList(reverseNode);
        reverseNode = reverseRsts[0];
        reverseEndNode = reverseRsts[1];

        if (firstStartNode == null) {
            firstStartNode = reverseNode;
            firstEndNode = reverseEndNode;
        } else {
            if (reverseEndNode != null) {
                firstEndNode.next = reverseNode;
                firstEndNode = reverseEndNode;
            }
        }

        if (firstStartNode == null) {
            return lastStartNode;
        } else {
            firstEndNode.next = lastStartNode;
            return firstStartNode;
        }
    }

    public ListNode[] reverseList(ListNode head) {
        if (head == null) {
            return new ListNode[]{head, head};
        }

        ListNode endNode = head;
        ListNode preNode = null, nextNode = head.next;
        while (nextNode != null) {
            nextNode = head.next;
            head.next = preNode;

            preNode = head;
            if (nextNode != null) {
                head = nextNode;
            }
        }

        return new ListNode[]{head, endNode};
    }
}
