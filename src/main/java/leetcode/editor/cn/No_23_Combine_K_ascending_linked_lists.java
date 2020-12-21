package leetcode.editor.cn;

//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法 
// 👍 820 👎 0

import org.junit.Test;

// MergeKSortedLists
public class No_23_Combine_K_ascending_linked_lists {
    @Test
    public void test() {
        ListNode[] lists = new ListNode[3];

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        lists[0] = node1;

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        lists[1] = node2;

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        lists[2] = node3;

        lists = new ListNode[2];
        lists[1] = new ListNode(1);

        ListNode listNode = mergeKLists(lists);
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeNode(lists, 0, lists.length - 1);
    }

    /**
     * 合并lists集合中的l ~ r 之间的ListNode
     *
     * @param lists
     * @param l
     * @param r
     * @return
     */
    ListNode mergeNode(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }

        if (r - l == 1) {
            return mergeNode(lists[l], lists[r]);
        }

        int mid = (r - l) >> 1;
        ListNode lNode = mergeNode(lists, l, l + mid);
        ListNode rNode = mergeNode(lists, l + mid + 1, r);

        return mergeNode(lNode, rNode);
    }

    ListNode mergeNode(ListNode lNode, ListNode rNode) {
        if (lNode == null && rNode == null) {
            return null;
        }

        if (lNode == null) {
            return rNode;
        }

        if (rNode == null) {
            return lNode;
        }

        ListNode mNode = null, curNode = null;
        while (lNode != null && rNode != null) {
            if (lNode.val > rNode.val) {
                if (curNode == null) {
                    curNode = rNode;
                    mNode = curNode;
                } else {
                    curNode.next = rNode;
                    curNode = curNode.next;
                }
                rNode = rNode.next;
            } else {
                if (curNode == null) {
                    curNode = lNode;
                    mNode = curNode;
                } else {
                    curNode.next = lNode;
                    curNode = curNode.next;
                }
                lNode = lNode.next;
            }
        }

        while (lNode != null) {
            curNode.next = lNode;
            curNode = curNode.next;
            lNode = lNode.next;
        }

        while (rNode != null) {
            curNode.next = rNode;
            curNode = curNode.next;
            rNode = rNode.next;
        }

        return mNode;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}