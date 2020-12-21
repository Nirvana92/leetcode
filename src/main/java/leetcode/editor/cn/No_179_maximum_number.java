package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class No_179_maximum_number {
    @Test
    public void test() {
        int[] nums = new int[]{999999998, 999999997, 999999999};
        String largestNumber = largestNumber(nums);
        System.out.println(largestNumber);
    }

    public String largestNumber(int[] nums) {
        Integer[] numbers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = nums[i];
        }
        Arrays.sort(numbers, new NumComparator());
        StringBuffer buffer = new StringBuffer();
        if (numbers[0] == 0) {
            return "0";
        }

        for (Integer number : numbers) {
            buffer.append(number);
        }
        return buffer.toString();
    }

    class NumComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String o12 = String.valueOf(o1) + String.valueOf(o2);
            String o21 = String.valueOf(o2) + String.valueOf(o1);
            return o21.compareTo(o12);
        }
    }
}
