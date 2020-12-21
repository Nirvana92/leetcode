package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 连续的最长子数组; 通过startMap 和endMap 来实现
 */
public class No_128_longest_continuous_sequence {
    @Test
    public void test() {
        int[] nums = new int[]{100, 4, 10, 200, 1, 3, 2, 5};
        nums = new int[]{-7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1, -7};
        nums = new int[]{7, -9, 3, -6, 3, 5, 3, 6, -2, -5, 8, 6, -4, -6, -4, -4, 5, -9, 2, 7, 0, 0};
        nums = new int[]{7, 5, 6, 8, 6, 5, 7};
        // Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int times = 100000;
        while (times-- > 0) {
            nums = Utils.generIntArr(200, 1000);
            // System.out.println(Arrays.toString(nums));
            int longestConsecutive = longestConsecutive(nums);
            int sortMethod = sortMethod(nums);
            if (longestConsecutive != sortMethod) {
                PrintUtils.print(nums);
                System.out.println(sortMethod + "; " + longestConsecutive);
                System.out.println("-------------------------------------------");
            }
        }
    }

    public int sortMethod(int[] nums) {
        Arrays.sort(nums);

        int maxLen = 0;
        Integer preNum = null;
        int tmplen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preNum == null) {
                preNum = nums[i];
                tmplen = 1;
            } else {
                if (nums[i] == preNum + 1 || nums[i] == preNum) {
                    if (nums[i] == preNum) continue;
                    preNum = nums[i];
                    tmplen++;
                } else {
                    maxLen = Math.max(maxLen, tmplen);

                    preNum = nums[i];
                    tmplen = 1;
                }
            }
        }

        return Math.max(maxLen, tmplen);
    }

    public int longestConsecutive(int[] nums) {
        // key: 数组中的每个值, value: 将值包装的Node
        Map<Integer, Node> startMap = new HashMap<>();
        Map<Integer, Node> endMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (startMap.containsKey(nums[i]) || endMap.containsKey(nums[i])) {
                continue;
            }
            Node node = new Node(nums[i]);

            // 是否初始化map, startMap endMap 加入初始的node
            boolean initNode = true;
            // 是否可以作为某个链表的开头, startindex 作为判断的值
            int startIndex = nums[i] + 1;
            if (startMap.containsKey(startIndex)) {
                Node exitNode = startMap.get(startIndex);
                exitNode.pre = node;
                node.next = exitNode;
                startMap.put(nums[i], node);
                startMap.remove(startIndex);

                initNode = false;
            }

            // 是否可以作为某个链表的结尾
            int endIndex = nums[i] - 1;
            if (endMap.containsKey(endIndex)) {
                Node exitNode = endMap.get(endIndex);
                exitNode.next = node;
                node.pre = exitNode;
                endMap.put(nums[i], node);
                endMap.remove(endIndex);

                initNode = false;
            }

            if (initNode && !startMap.containsKey(nums[i]) && !endMap.containsKey(nums[i])) {
                startMap.put(nums[i], node);
                endMap.put(nums[i], node);
            }

            // 删除连接点的 开头节点和结尾节点
            if (startMap.containsKey(nums[i]) && endMap.containsKey(nums[i]) && node.next != null && node.pre != null) {
                startMap.remove(nums[i]);
                endMap.remove(nums[i]);
            }
        }

        // 遍历找到最大的连续长度
        int maxLen = 0;
        for (Map.Entry<Integer, Node> entry : startMap.entrySet()) {
            int tmpLen = 0;
            Node node = entry.getValue();
            while (node != null) {
                tmpLen++;
                node = node.next;
            }

            maxLen = Math.max(maxLen, tmpLen);
        }

        return maxLen;
    }

    class Node {
        public int val;
        public Node pre;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
