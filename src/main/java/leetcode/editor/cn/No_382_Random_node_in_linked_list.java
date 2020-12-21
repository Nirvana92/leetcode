package leetcode.editor.cn;

import java.util.Random;

/**
 * @author Nirvana
 * @date 2020/10/24 00:13
 * <p>
 * 382. 链表随机节点
 * <p>
 * 蓄水池算法应用
 */
public class No_382_Random_node_in_linked_list {

    class Solution {
        ListNode head;
        Random random;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            ListNode tmpNode = this.head;
            int val = tmpNode.val;
            int nodeCouns = 1;
            while (tmpNode != null) {
                if (random.nextInt(nodeCouns++) == 0) {
                    val = tmpNode.val;
                }

                tmpNode = tmpNode.next;
            }

            return val;
        }
    }
}
