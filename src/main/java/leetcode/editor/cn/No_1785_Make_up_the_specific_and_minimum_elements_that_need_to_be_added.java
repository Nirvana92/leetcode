package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/3/10 7:21 下午
 * @desc: 1785. 构成特定和需要添加的最少元素
 */
public class No_1785_Make_up_the_specific_and_minimum_elements_that_need_to_be_added {
    @Test
    public void test() {
        int[] nums = new int[]{1, -1, 1};
        int limit = 3, goal = -4;

        nums = new int[]{1, -10, 9, 1};
        limit = 100;
        goal = 0;

        int minElements = minElements(nums, limit, goal);
        System.out.println(minElements);
    }

    public int minElements(int[] nums, int limit, int goal) {
        // 需要考虑数据溢出的问题
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long diffVal = Math.abs(goal - sum);
        return (int) ((diffVal / limit) + (diffVal % limit == 0 ? 0 : 1));
    }
}
