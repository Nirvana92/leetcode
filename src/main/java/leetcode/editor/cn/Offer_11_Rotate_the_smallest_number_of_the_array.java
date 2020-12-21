package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/11/5 8:55 下午
 * @desc: 剑指 Offer 11. 旋转数组的最小数字
 */
public class Offer_11_Rotate_the_smallest_number_of_the_array {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (numbers[mid] < numbers[r]) {
                r = mid;
            } else if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }

        return numbers[l];
    }
}
