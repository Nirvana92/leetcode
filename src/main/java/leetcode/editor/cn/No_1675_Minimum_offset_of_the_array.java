package leetcode.editor.cn;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @author Nirvana
 * @date 2020/12/16 22:45
 * <p>
 * 参考: {@link leetcode.editor.cn.No_632_Minimum_interval}
 * <p>
 * 你可以对数组的任意元素执行任意次数的两类操作：
 * <p>
 * 如果元素是 偶数 ，除以 2
 * 例如，如果数组是 [1,2,3,4] ，那么你可以对最后一个元素执行此操作，使其变成 [1,2,3,2]
 * 如果元素是 奇数 ，乘上 2
 * 例如，如果数组是 [1,2,3,4] ，那么你可以对第一个元素执行此操作，使其变成 [2,2,3,4]
 * 数组的 偏移量 是数组中任意两个元素之间的 最大差值 。
 * <p>
 * 返回数组在执行某些操作之后可以拥有的 最小偏移量 。
 */
public class No_1675_Minimum_offset_of_the_array {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4};
//        nums = new int[]{4, 1, 5, 20, 3};
//        nums = new int[]{2, 10, 8};

        int minimumDeviation = minimumDeviation(nums);
        System.out.println(minimumDeviation);
    }

    /**
     * 因为是任意两个数的差值即该数组的偏移量
     * 所以解决本题的步骤就是:
     * 1. 将数组的值增大到最大值放到堆中
     * 2. 然后依次缩小最大值, 求得每次的偏移量, 计算每次的结果
     * 3. 得到最终的结果返回
     *
     * @param nums
     * @return
     */
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> sets = new TreeSet<>();
        for (int num : nums) {
            sets.add(num % 2 == 0 ? num : 2 * num);
        }

        int ret = Integer.MAX_VALUE;
        while (true) {
            int first = sets.first(), last = sets.pollLast();
            ret = Math.min(ret, last - first);
            if (last % 2 == 0) {
                sets.add(last >> 1);
            } else {
                break;
            }
        }

        return ret;
    }

    @Test
    public void t() {
        TreeSet<Integer> sets = new TreeSet<>();

        sets.add(3);
        sets.add(2);

        System.out.println(sets.first());
        System.out.println(sets.last());
    }
}
