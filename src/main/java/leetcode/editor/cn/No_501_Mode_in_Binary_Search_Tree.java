package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

/**
 * @author gzm
 * @date 2020/9/24 10:35 上午
 * @desc
 */
public class No_501_Mode_in_Binary_Search_Tree {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        TreeNode rl = new TreeNode(2);
        r.left = rl;
        root.right = r;

        int[] mode = findMode(root);
        System.out.println(Arrays.toString(mode));
    }

    public int[] findMode(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> maps = new HashMap<>();

        int maxCount = process(root, maps);
        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            if (entry.getValue() == maxCount) {
                results.add(entry.getKey());
            }
        }


        int[] rsts = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            rsts[i] = results.get(i);
        }

        return rsts;
    }

    /**
     * @param root
     * @param maps
     * @return: 返回最大的次数
     */
    int process(TreeNode root, Map<Integer, Integer> maps) {
        if (root == null) {
            return 0;
        }

        int curNumCount = maps.getOrDefault(root.val, 0) + 1;
        maps.put(root.val, curNumCount);
        curNumCount = Math.max(process(root.left, maps), curNumCount);
        curNumCount = Math.max(process(root.right, maps), curNumCount);

        return curNumCount;
    }
}
