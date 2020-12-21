package leetcode.editor.cn;

/**
 * @author Nirvana
 * @date 2020/10/31 22:08
 * <p>
 * 167. 两数之和 II - 输入有序数组
 */
public class No_167_Sum_of_Two_Numbers_II_Input_an_ordered_array {


    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[]{};
    }
}
