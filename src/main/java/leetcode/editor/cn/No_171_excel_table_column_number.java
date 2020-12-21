package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/22 4:03 下午
 * @desc
 */
public class No_171_excel_table_column_number {
    @Test
    public void test() {
        String str = "";
        int titleToNumber = titleToNumber(str);
        System.out.println(titleToNumber);
    }

    public int titleToNumber(String s) {
        int number = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            number = number * 26 + (chars[i] - 'A' + 1);
        }

        return number;
    }
}
