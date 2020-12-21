package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/24 17:43
 * <p>
 * 1404. 将二进制表示减到 1 的步骤数
 * <p>
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * 如果当前数字为偶数，则将其除以 2 。
 * 如果当前数字为奇数，则将其加上 1 。
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 */
public class No_1404_Number_of_steps_to_reduce_the_binary_representation_to_1 {
    @Test
    public void test() {
        String s = "1101";
        s = "10";
        s = "1";

        int numSteps = numSteps(s);
        System.out.println(numSteps);
    }

    @Test
    public void testBaoli() {
        Integer times = 1000;
        while (times-- > 0) {
            int numSteps = numSteps(Integer.toBinaryString(times));
        }
    }

    public int numSteps(String s) {
        int sIndex = s.length() - 1;
        // s = removeHeadZero(s);
        int numSteps = 0, preNum = 0;
        while (sIndex > 0) {
            int curNum = s.charAt(sIndex) - '0' + preNum;
            preNum = curNum >> 1;
            curNum %= 2;

            if ((curNum & 1) == 1) {
                // 奇数, 进位1
                preNum = 1;
                numSteps++;
            } else {
                //偶数, 除2

            }

            numSteps++;
            sIndex--;
        }

        int curNum = s.charAt(sIndex) - '0' + preNum;
        if (curNum % 2 == 0) {
            numSteps++;
        }

        return numSteps;
    }

//    String removeHeadZero(String s) {
//        int sIndex = -1;
//        while (sIndex + 1 < s.length()) {
//            if (s.charAt(sIndex + 1) == '0') {
//                sIndex++;
//            } else {
//                break;
//            }
//        }
//        if (sIndex == -1) {
//            return s;
//        }
//        return s.substring(sIndex + 1, s.length());
//    }


}
