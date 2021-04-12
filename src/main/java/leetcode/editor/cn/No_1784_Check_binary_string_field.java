package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/3/9 11:34 上午
 * @desc: 1784. 检查二进制字符串字段
 */
public class No_1784_Check_binary_string_field {
    @Test
    public void test() {
        String s = "10001";
        s = "10000";
        boolean checkOnesSegment = checkOnesSegment(s);
        System.out.println(checkOnesSegment);
    }

    public boolean checkOnesSegment(String s) {
        int numOfOnes = 0;
        int firstOneIndex = -1, lastOneIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                numOfOnes++;

                if (firstOneIndex == -1) {
                    firstOneIndex = i;
                }

                lastOneIndex = i;
            }
        }

        return numOfOnes == (lastOneIndex - firstOneIndex + 1);
    }
}
