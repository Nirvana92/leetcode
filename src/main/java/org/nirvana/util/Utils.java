package org.nirvana.util;

import leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    private static Random random = new Random();

    public static boolean isOddNum(int num) {
        return (num & 1) == 1;
    }

    /**
     * 随机生成一个值
     *
     * @param min: 值的下限
     * @param max: 值的上限
     * @return
     */
    public static int generInt(int min, int max) {
        return random.nextInt(max) + min;
    }

    /**
     * 生成数组
     *
     * @param arrLenBase: 最小的数组长度
     * @param arrLenMax:  最大的数据长度
     * @param arrValBase: 数组中的最小值
     * @param arrValMax:  数组中的最大值
     * @return
     */
    public static int[] generIntArr(int arrLenBase, int arrLenMax, int arrValBase, int arrValMax) {
        Random random = new Random();
        int[] arrs = new int[random.nextInt(arrLenMax) + arrLenBase];

        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = random.nextInt(arrValMax - arrValBase) + arrValBase;
        }

        return arrs;
    }

    public static int[] generIntArr(int arrLen, int maxVal) {
        Random random = new Random();
        int[] is = new int[arrLen];

        while (arrLen > 0) {
            is[--arrLen] = random.nextInt(maxVal);
        }

        return is;
    }

    public static String generStr(char l, char r, int len) {
        StringBuffer buffer = new StringBuffer();

        Random random = new Random();
        for (int i = 0; i < len; i++) {
            int index = random.nextInt(r - l + 1);
            buffer.append((char) (l + index));
        }

        return buffer.toString();
    }

    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static List<Integer> copyLists(List<Integer> paths) {
        List<Integer> copyList = new ArrayList<>();
        for (Integer num : paths) {
            copyList.add(num);
        }

        return copyList;
    }

    public static void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
