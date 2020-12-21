package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/10/4 12:14 上午
 * @desc
 */
public class No_2_Add_two_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rstListNode = null, tempListNode = null;
        int nextAddVal = 0;
        int tempBit = 10;
        while (true) {
            int firstVal = 0, secondVal = 0;
            if (l1 != null) {
                firstVal = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                secondVal = l2.val;
                l2 = l2.next;
            }

            if ((firstVal != 0 || secondVal != 0 || nextAddVal > 0)) {
                int rst = firstVal + secondVal;
                int currentVal = (rst + nextAddVal) % tempBit;
                nextAddVal = (rst + nextAddVal) / tempBit;

                if (rstListNode == null) {
                    rstListNode = new ListNode(currentVal);
                    tempListNode = rstListNode;
                } else {
                    ListNode currentListNode = new ListNode(currentVal);

                    tempListNode.next = currentListNode;
                    tempListNode = currentListNode;
                }

            } else {
                if (l1 == null && l2 == null && rstListNode != null) {
                    break;
                } else {
                    if (rstListNode == null) {
                        rstListNode = new ListNode(0);
                        tempListNode = rstListNode;
                    } else {
                        ListNode currentListNode = new ListNode(0);

                        tempListNode.next = currentListNode;
                        tempListNode = currentListNode;
                    }
                }
            }
        }

        return rstListNode;
    }
}
