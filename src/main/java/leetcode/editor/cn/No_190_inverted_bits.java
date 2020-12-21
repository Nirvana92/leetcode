package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/22 4:52 下午
 * @desc
 */
public class No_190_inverted_bits {
    @Test
    public void test() {
        int n = 43261596;
        int reverseBits = reverseBits(n);
        System.out.println(reverseBits);
    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            if (((n >>> i) & 1) == 1) {
                result ^= 1;
            }
        }
        return result;
    }
}
