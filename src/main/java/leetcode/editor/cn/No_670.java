package leetcode.editor.cn;

//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 108] 
// 
// Related Topics 数组 数学 
// 👍 83 👎 0

import org.nirvana.util.Utils;

public class No_670 {
    public static void main(String[] args) {
        Solution solution = new No_670().new Solution();
//        int num = 9973;
        int times = 100000, min = 0, max = (int) Math.pow(10d, 8d);

//        System.out.println(solution.maximumSwap(71084821));
//        System.out.println(solution.maximumSwapWithViolence(71084821));

//        System.out.printf("max : %d ", max);
        while (times-- > 0) {
            int num = Utils.generInt(min, max);

            int maximumSwap = solution.maximumSwap(num);
            int maximumSwapWithViolence = solution.maximumSwapWithViolence(num);

            if(maximumSwap != maximumSwapWithViolence) {
                System.out.printf("---num: %d ", num);
                System.out.printf("---maximumSwap: %d ", maximumSwap);
                System.out.printf("---maximumSwapWithViolence: %d ", maximumSwapWithViolence);
                System.out.println();
            }
        }
    }

    class Solution {
        public int maximumSwap(int num) {
            char[] chars = String.valueOf(num).toCharArray();

            // chars[] = {9, 9, 7, 3}
            // maxValIndex[i]: 表示 len-1 ~ i-1 位置上最大的数, 如果存在相同的数, 取index 小的
            int[] maxValIndex = new int[chars.length];
            for (int lIndex = maxValIndex.length - 1; lIndex >= 0; lIndex--) {
                maxValIndex[lIndex] = ((lIndex + 1) >= maxValIndex.length)
                        ? lIndex
                        : (chars[lIndex+1] > chars[maxValIndex[lIndex+1]]
                            ? (lIndex+1)
                            : maxValIndex[lIndex+1]);
            }

//            System.out.printf(" maxValIndex: %s ", Arrays.toString(maxValIndex));

            for (int i = 0; i < maxValIndex.length; i++) {
                if(chars[maxValIndex[i]] > chars[i]) {
                    char tmp = chars[i];
                    chars[i] = chars[maxValIndex[i]];
                    chars[maxValIndex[i]] = tmp;

                    break;
                }
            }

            return Integer.parseInt(String.valueOf(chars));
        }

        /**
         * 暴力法得出结果
         * @param num
         * @return
         */
        public int maximumSwapWithViolence(int num) {
            String rst = String.valueOf(num);

            for (int i = 0; i < rst.length(); i++) {
                for (int j = i+1; j < rst.length(); j++) {
                    char[] chars = String.valueOf(num).toCharArray();
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;

                    String curStr = String.valueOf(chars);
                    if(curStr.compareTo(rst) > 0) {
                        rst = curStr;
                    }
                }
            }

            return Integer.parseInt(rst);
        }
    }
}