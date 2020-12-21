package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nirvana
 * @date 2020/10/24 23:24
 * <p>
 * 228. 汇总区间
 */
public class No_228_Summary_interval {
    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};
        nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        nums = new int[]{};
        nums = new int[]{-1};
        nums = new int[]{0};

        List<String> stringList = summaryRanges(nums);
        System.out.println(stringList);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> rsts = new ArrayList<>();

        int preIndex = 0, curIndex = 0;
        while (curIndex + 1 < nums.length) {
            if (nums[curIndex + 1] - nums[curIndex] == 1) {
                curIndex++;
            } else {
                // 统计结果
                if (preIndex == curIndex) {
                    rsts.add(String.valueOf(nums[preIndex]));
                } else {
                    rsts.add(nums[preIndex] + "->" + nums[curIndex]);
                }

                preIndex = curIndex + 1;
                curIndex++;
            }
        }

        if (preIndex < nums.length) {
            if (preIndex == curIndex) {
                rsts.add(String.valueOf(nums[preIndex]));
            } else {
                rsts.add(nums[preIndex] + "->" + nums[curIndex]);
            }
        }

        return rsts;
    }
}
