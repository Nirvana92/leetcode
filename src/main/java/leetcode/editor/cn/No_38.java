package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/18 4:16 下午
 * @desc
 */
public class No_38 {
    @Test
    public void test() {
        int n = 0;
        String result = countAndSay(n);
        System.out.println(result);
    }

    public String countAndSay(int n) {
        String result = "1";
        // 地推的次数
        for (int i = 0; i < n - 1; i++) {
            result = countNums(result);
        }

        return result;
    }

    String countNums(String nums) {
        if (nums == null || nums.length() == 0) {
            return nums;
        }

        StringBuffer buffer = new StringBuffer();
        char[] chars = nums.toCharArray();

        Character preChar = null;
        int preCount = 0;
        int curIndex = 0;
        while (curIndex < nums.length()) {
            if (preChar == null) {
                preChar = chars[curIndex];
                preCount++;
            } else {
                if (preChar == chars[curIndex]) {
                    preCount++;
                } else {
                    // 不同, 统计之前的内容然后保存到buffer
                    buffer.append(preCount).append(preChar);
                    preChar = chars[curIndex];
                    preCount = 1;
                }
            }

            curIndex++;
        }

        if (preChar != null) {
            buffer.append(preCount).append(preChar);
        }

        return buffer.toString();
    }
}
