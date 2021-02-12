package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

/**
 * @author Nirvana
 * @date 2020/10/31 20:58
 * <p>
 * 978. 最长湍流子数组
 */
public class No_978_Longest_turbulence_subarray {
    @Test
    public void test() {
        int[] nums = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
        nums = new int[]{4, 8, 12, 16};
        nums = new int[]{1, 1, 1, 1};
        nums = new int[]{3, 5, 3, 3, 5, 8, 3, 6};
        // nums = new int[]{100};

        int maxTurbulenceSize = maxTurbulenceSize(nums);
        System.out.println(maxTurbulenceSize);

        int baoli = baoli(nums);
        System.out.println(baoli);
    }

    @Test
    public void t() {
        int times = 10000;

        while (times-- > 0) {
            int[] arrs = Utils.generIntArr(1, 10, 1, 10);
            int maxTurbulenceSize = maxTurbulenceSize(arrs);
            int baoli = baoli(arrs);

            if (maxTurbulenceSize != baoli) {
                PrintUtils.print(arrs);
                System.out.println("maxTurbulenceSize: " + maxTurbulenceSize);
                System.out.println("baoli: " + baoli);
                break;
            }
        }
    }

    public int maxTurbulenceSize(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int maxLen = 1, lIndex = 0, rIndex = 1;
        while (rIndex < nums.length) {
            int preRelation = Integer.compare(nums[rIndex], nums[lIndex]);
            if (preRelation == 0) {
                lIndex = rIndex;
                rIndex++;
                continue;
            }

            while (rIndex + 1 < nums.length) {
                int curRelation = Integer.compare(nums[rIndex + 1], nums[rIndex]);
                if (preRelation + curRelation == 0) {
                    preRelation = curRelation;
                    rIndex++;
                } else {
                    break;
                }
            }

            maxLen = Math.max(maxLen, rIndex - lIndex + 1);
            lIndex = rIndex;
            rIndex++;
        }

        return maxLen;
    }

    public int baoli(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int maxLen = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int rIndex = i + 1;
            int preRelation = Integer.compare(nums[rIndex], nums[i]);
            if (preRelation != 0) {
                while (rIndex + 1 < nums.length) {
                    int tmpRelation = Integer.compare(nums[rIndex + 1], nums[rIndex]);

                    if (tmpRelation + preRelation == 0) {
                        preRelation = tmpRelation;
                        rIndex++;
                    } else {
                        break;
                    }
                }
                maxLen = Math.max(maxLen, rIndex - i + 1);
            }
        }

        return maxLen;
    }
}
