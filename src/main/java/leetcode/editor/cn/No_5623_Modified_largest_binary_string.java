package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/28 9:47 上午
 * @desc: 5623. 修改后的最大二进制字符串
 * <p>
 * <p>
 * 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
 * <p>
 * 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
 * 比方说， "00010" -> "10010"
 * 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
 * 比方说， "00010" -> "00001"
 * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，
 * 那么我们称二进制字符串 x 大于二进制字符串 y 。
 * <p>
 * binary.length <= 10 ^ 5 . 使用下面的动态查找位置有可能会超时, 所以使用辅助数组处理
 */
public class No_5623_Modified_largest_binary_string {
    @Test
    public void test() {
        String binary = "000110";
        // binary = "01";
        binary = "0001111001";

        String maximumBinaryString = maximumBinaryString(binary);
        System.out.println(maximumBinaryString);
    }

    /**
     * 转化成数组, 从头往后开始变更 00 -> 10 .
     * 然后碰到 01 这种情况, 查看后面 1 开始是否又连续的 1是以0收尾的, 有的话, 将连续的1 往右移动一位
     * 然后再进行后移求解操作
     * <p>
     * 做了一个小优化: 就是记录下次查找0 的下标从什么地方开始, 避免超时
     *
     * @param binary
     * @return
     */
    public String maximumBinaryString(String binary) {
        // 二进制数组
        char[] binarys = binary.toCharArray();
        int nextStartIndex = -1;

        for (int i = 0; i < binary.length() - 1; i++) {
            if (binarys[i] == '1') {
                continue;
            }

            // i: 当前位置为 0
            // if (binarys[i + 1] == '0' || rightMove(binarys, i + 1)) {
            if (binarys[i + 1] == '0') {
                // 下一个位置 0
                binarys[i] = '1';
            } else {
                nextStartIndex = rightMove(binarys, i + 1, nextStartIndex);
                if (nextStartIndex > 0 && nextStartIndex <= binarys.length) {
                    binarys[i] = '1';
                }
                String tmpStr = new String(binarys);

                if (nextStartIndex >= binarys.length) {
                    break;
                }
            }
        }

        return new String(binarys);
    }

    /**
     * @param binarys:        原始数组
     * @param index:          当前开始的下标位置
     * @param nextStartIndex: 下一个0 的下标位置
     * @return
     */
    int rightMove(char[] binarys, int index, int nextStartIndex) {
        boolean findZero = nextStartIndex >= 0 && nextStartIndex < binarys.length && binarys[nextStartIndex] == '0';
        if (nextStartIndex <= index || binarys[nextStartIndex] == '1') {
            for (int i = Math.max(index + 1, nextStartIndex); i < binarys.length; i++) {
                if (binarys[i] == '0') {
                    nextStartIndex = i;
                    findZero = true;
                    break;
                }
            }
        }

        if (findZero) {
            binarys[index] = '0';
            binarys[nextStartIndex] = '1';
            nextStartIndex = nextStartIndex + 1;
        } else {
            nextStartIndex = binarys.length + 1;
        }

        return nextStartIndex;
    }

    /**
     * 判断当前位置: 1, 第一个遇到的 0, 然后往后移动一位
     *
     * @param binarys
     * @param index
     */
    boolean rightMove(char[] binarys, int index) {
        int endIndex = -1;
        for (int i = index + 1; i < binarys.length; i++) {
            if (binarys[i] == '0') {
                endIndex = i;
                break;
            }
        }

        // 移动 index ... endIndex 位置的数据
        if (endIndex > index) {
            binarys[index] = '0';
            binarys[endIndex] = '1';
        }

        return endIndex > index;
    }
}
