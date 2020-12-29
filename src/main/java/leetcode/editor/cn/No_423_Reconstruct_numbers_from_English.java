package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/24 9:51 上午
 * @desc: 423. 从英文中重建数字
 * <p>
 * 无聊的题目, 后续可以不用看
 */
public class No_423_Reconstruct_numbers_from_English {
    @Test
    public void test() {
        String s = "owoztneoer";
        s = "fviefuro";

        String originalDigits = originalDigits(s);
        System.out.println(originalDigits);
    }

    String[] strs = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    /**
     * 这个题目有点无聊
     *
     * @param s
     * @return
     */
    public String originalDigits(String s) {
        // zero         // z
        // one
        // two          // w
        // three        // h : 必须要在 eight 处理完成之后
        // four         // u
        // five         // v ： 必须要在seven 处理完成之后
        // six          // x
        // seven        // s : 必须要在six 处理完之后
        // eight        // g
        // nine         // i : 处理, 倒数第二个处理

        int[] bitCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bitCounts[s.charAt(i) - 'a']++;
        }

        // 记录 0 ~ 9 这几个数字出现的个数
        int[] resultCounts = new int[10];

        // 1. 处理zero
        resultCounts[0] = bitCounts['z' - 'a'];
        calCounts(bitCounts, strs[0], resultCounts[0]);

        // 2. 处理two
        resultCounts[2] = bitCounts['w' - 'a'];
        calCounts(bitCounts, strs[2], resultCounts[2]);

        // 3. 处理four
        resultCounts[4] = bitCounts['u' - 'a'];
        calCounts(bitCounts, strs[4], resultCounts[4]);

        // 4. 处理 six
        resultCounts[6] = bitCounts['x' - 'a'];
        calCounts(bitCounts, strs[6], resultCounts[6]);

        // 5. 处理 eight
        resultCounts[8] = bitCounts['g' - 'a'];
        calCounts(bitCounts, strs[8], resultCounts[8]);

        // 6. three
        resultCounts[3] = bitCounts['h' - 'a'];
        calCounts(bitCounts, strs[3], resultCounts[3]);

        // 7. seven
        resultCounts[7] = bitCounts['s' - 'a'];
        calCounts(bitCounts, strs[7], resultCounts[7]);

        // 8. five
        resultCounts[5] = bitCounts['v' - 'a'];
        calCounts(bitCounts, strs[5], resultCounts[5]);

        // 9. nine
        resultCounts[9] = bitCounts['i' - 'a'];
        calCounts(bitCounts, strs[9], resultCounts[9]);

        // 10. one
        resultCounts[1] = bitCounts['o' - 'a'];
        calCounts(bitCounts, strs[1], resultCounts[1]);

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < resultCounts[i]; j++) {
                buffer.append(i);
            }
        }

        return buffer.toString();
    }

    public void calCounts(int[] bitCounts, String numStr, int reduceNum) {
        for (int i = 0; i < numStr.length(); i++) {
            bitCounts[numStr.charAt(i) - 'a'] -= reduceNum;
        }
    }
}
