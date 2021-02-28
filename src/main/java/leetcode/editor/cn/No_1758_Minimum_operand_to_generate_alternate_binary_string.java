package leetcode.editor.cn;

/**
 * @author Nirvana
 * @date 2021/2/28 01:44
 * <p>
 * 1758. 生成交替二进制字符串的最少操作数
 */
public class No_1758_Minimum_operand_to_generate_alternate_binary_string {
    public int minOperations(String s) {
        // 处理思路确定第一个字符串应该是0 还是1 然后依次往后遍历求得变更的次数
        int firstZeroNums = s.charAt(0) == '0' ? 0 : 1, firstOneNums = s.charAt(0) == '1' ? 0 : 1;

        for (int i = 1; i < s.length(); i++) {
            // 0 1 0 1 0 1 0 1 0 1 0 1
            if ((i % 2 == 1 && s.charAt(i) == '0') || (i % 2 == 0 && s.charAt(i) == '1')) {
                firstZeroNums++;
            }

            // 1 0 1 0 1 0 1 0 1 0 1 0
            if ((i % 2 == 1 && s.charAt(i) == '1') || (i % 2 == 0 && s.charAt(i) == '0')) {
                firstOneNums++;
            }
        }

        return Math.min(firstZeroNums, firstOneNums);
    }
}
