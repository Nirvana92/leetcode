package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/7 14:19
 * <p>
 * 565. 数组嵌套
 */
public class No_565_Array_nesting {
    @Test
    public void test() {
        int[] nums = new int[]{5, 4, 0, 3, 1, 6, 2};
        int arrayNesting = arrayNesting(nums);
        System.out.println(arrayNesting);
    }

    public int arrayNesting(int[] nums) {
        boolean[] seen = new boolean[nums.length];

        int count = 0, ret = 0;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            int curIndex = i;
            while (!seen[curIndex]) {
                count++;
                int preNum = nums[curIndex];
                seen[curIndex] = true;
                curIndex = preNum;
            }

            ret = Math.max(ret, count);
        }

        return ret;
    }
}
