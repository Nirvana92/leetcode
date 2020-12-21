package leetcode.editor.cn;

//给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: 210 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: 9534330 
//
// 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
// Related Topics 排序 
// 👍 336 👎 0

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

// LargestNumber
public class No_179 {
    public static void main(String[] args) {
        Solution solution = new No_179().new Solution();
        int[] arrs = new int[]{3, 30, 34, 5, 9};
        String rst = solution.largestNumber(arrs);
        System.out.println(rst);
    }

    class Solution {
        public String largestNumber(int[] nums) {
            StringBuffer buffer = new StringBuffer();
            Arrays.stream(nums).boxed().map(num -> String.valueOf(num)).sorted(new LargestNumberComparator()).forEach(num -> {
                buffer.append(num);
            });

            return buffer.toString();
        }
    }

    class LargestNumberComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o2 + o1).compareTo((o1 + o2));
        }
    }

    @Test
    public void t() {
        int[] arrs = new int[]{10, 4};
        StringBuilder builder = new StringBuilder();

        Arrays.stream(arrs).boxed().map(num -> String.valueOf(num)).sorted(new LargestNumberComparator()).forEach(num -> {
            builder.append(num);
        });

        System.out.println(builder.toString());
    }
}