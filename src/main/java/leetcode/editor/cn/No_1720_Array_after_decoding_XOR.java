package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2021/1/19 5:27 下午
 * @desc: 1720. 解码异或后的数组
 */
public class No_1720_Array_after_decoding_XOR {
    @Test
    public void test() {
        int[] encoded = new int[]{1, 2, 3};
        int first = 1;

        encoded = new int[]{6, 2, 7, 3};
        first = 4;

        int[] decode = decode(encoded, first);
        PrintUtils.print(decode);
    }

    public int[] decode(int[] encoded, int first) {
        int[] orginal = new int[encoded.length + 1];
        orginal[0] = first;

        for (int i = 1; i < orginal.length; i++) {
            orginal[i] = encoded[i - 1] ^ orginal[i - 1];
        }

        return orginal;
    }
}
