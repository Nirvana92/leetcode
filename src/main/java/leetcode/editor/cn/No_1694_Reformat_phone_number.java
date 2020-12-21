package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/21 9:41 上午
 * @desc: 5629. 重新格式化电话号码
 */
public class No_1694_Reformat_phone_number {
    @Test
    public void test() {
        String number = "1-23-45 6";
        number = "123 4-567";
        number = "123 4-5678";
        number = "12";
        number = "--17-5 229 35-39475 ";

        String reformatNumber = reformatNumber(number);
        System.out.println(reformatNumber);
    }

    public String reformatNumber(String number) {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == ' ' || number.charAt(i) == '-') {
                continue;
            }

            buffer.append(number.charAt(i));
        }

        StringBuffer ret = new StringBuffer();

        int len = buffer.length();
        int segmentLen = len / 3;
        int remindNum = len % 3, remindLen = 0;
        if (remindNum == 1) {
            segmentLen--;
            remindLen = 2;
        } else if (remindNum == 2) {
            remindLen = 1;
        }

        for (int i = 0; i < segmentLen; i++) {
            for (int j = i * 3; j < (i + 1) * 3; j++) {
                ret.append(buffer.charAt(j));
            }
            ret.append('-');
        }

        for (int i = 0; i < remindLen; i++) {
            for (int j = segmentLen * 3 + i * 2; j < segmentLen * 3 + (i + 1) * 2; j++) {
                ret.append(buffer.charAt(j));
            }
            ret.append('-');
        }

        return ret.substring(0, ret.length() - 1);
    }
}
