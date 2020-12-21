package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/9/22 2:58 下午
 * @desc
 */
public class No_160_intersecting_linked_list {

    /**
     * 具体的实现可以参考: org.nirvana.linked.LinkedIntersect#getFirstIntersectNoRing(org.nirvana.linked.Node, org.nirvana.linked.Node)
     * 无环的实现
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int linkedOneLen = getLinkedLen(headA);
        int linkedTwoLen = getLinkedLen(headB);

        int moveStep = Math.abs(linkedOneLen - linkedTwoLen);
        if (linkedOneLen > linkedTwoLen) {
            while (moveStep-- != 0) {
                headA = headA.next;
            }
        }
        if (linkedTwoLen > linkedOneLen) {
            while (moveStep-- != 0) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public int getLinkedLen(ListNode header) {
        int len = 0;

        while (header != null) {
            len++;
            header = header.next;
        }

        return len;
    }
}
