package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/29 8:32 下午
 * @desc: 852. 山脉数组的峰顶索引
 * <p>
 * 二分法查找
 */
public class No_852_Peak_index_of_the_mountain_array {
    @Test
    public void test() {
        int[] arrays = new int[]{0, 1, 0};
        arrays = new int[]{0, 2, 1, 0, 0, 0};

        int peakIndexInMountainArray = peakIndexInMountainArray(arrays);
        System.out.println(peakIndexInMountainArray);
    }

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) >> 1;

            if (arr[mid] < arr[mid - 1]) {
                r = mid;
            } else if (arr[mid] < arr[mid + 1]) {
                l = mid;
            } else {
                return mid;
            }
        }

        return l;
    }
}
