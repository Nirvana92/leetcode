package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/25 5:46 下午
 * @desc
 */
public class No_43_String_multiplication {
    @Test
    public void test() {
        String num1 = "56498456156456156", num2 = "234674964321654869413216546";
        String multiply = multiply(num1, num2);
        System.out.println(multiply);
    }

    public String multiply(String num1, String num2) {
        String result = "0";
        if ("0".equals(num1) || "0".equals(num2)) {
            return result;
        }

        char[] num1s = num1.toCharArray();
        char[] num2s = num2.toCharArray();
        int N = num2s.length;
        StringBuffer zeroBuffer = new StringBuffer();
        for (int i = N - 1; i >= 0; i--) {
            String tmpRst = multiplySingle(num1s, num2s[i]);
            if (i != N - 1) {
                zeroBuffer.append("0");
            }

            tmpRst = tmpRst + zeroBuffer.toString();
            result = result.length() > tmpRst.length() ? add(result, tmpRst) : add(tmpRst, result);
        }

        return result;
    }

    @Test
    public void testAdd() {
        String num1 = "1852", num2 = "453";
        String add = add(num1, num2);
        System.out.println(add);
    }

    /**
     * 两数相加: num1 的长度 >= num2
     *
     * @param num1
     * @param num2
     * @return
     */
    String add(String num1, String num2) {
        StringBuffer buffer = new StringBuffer();
        char[] num1s = num1.toCharArray();
        char[] num2s = num2.toCharArray();

        // int diffVal = Math.abs(num1s.length - num2s.length);
        int num1Index = num1s.length - 1;
        int num2Index = num2s.length - 1;
        int preNum = 0;
        while (num2Index >= 0) {
            int curNum = (num1s[num1Index--] - '0') + (num2s[num2Index--] - '0') + preNum;
            preNum = curNum / 10;
            buffer.append(curNum % 10);
        }

        for (int i = num1Index; i >= 0; i--) {
            int curNum = (num1s[i] - '0') + preNum;
            preNum = curNum / 10;
            buffer.append(curNum % 10);
        }

        if (preNum > 0) {
            buffer.append(preNum);
        }

        return buffer.reverse().toString();
    }

    /**
     * 两数相乘
     *
     * @param num1s
     * @param singleNum
     * @return
     */
    String multiplySingle(char[] num1s, char singleNum) {
        StringBuffer resultBuffer = new StringBuffer();
        int preNum = 0;
        int sNum = singleNum - '0';
        for (int i = num1s.length - 1; i >= 0; i--) {
            int curNum = (num1s[i] - '0') * sNum + preNum;

            preNum = curNum / 10;
            resultBuffer.append(curNum % 10);
        }

        if (preNum > 0) {
            resultBuffer.append(preNum);
        }

        return resultBuffer.reverse().toString();
    }
}
