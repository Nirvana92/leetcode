package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2021/1/4 11:49 上午
 * @desc: 5642. 大餐计数
 * <p>
 * 两数之和问题扩展
 * 复习: 变种题目, 根据数据范围将O(n) 变换为固定长度的计算
 */
public class No_5642_Big_meal_count {
    @Test
    public void test() {
        int[] deliciousness = new int[]{1, 3, 5, 7, 9};
        //deliciousness = new int[]{1, 1, 1, 3, 3, 3, 7};

        int countPairs = countPairs(deliciousness);
        System.out.println(countPairs);
    }

    public int countPairs(int[] deliciousness) {
        int mod = 1000000007;
        long ret = 0L;

        // 如果无序, 需要进行下排序
        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < deliciousness.length; i++) {
            int targetSum = 1;
            for (int power = 0; power < 22; power++) {
                if (maps.containsKey(targetSum - deliciousness[i])) {
                    ret += maps.get(targetSum - deliciousness[i]);
                }

                targetSum <<= 1;
            }
            maps.put(deliciousness[i], maps.getOrDefault(deliciousness[i], 0) + 1);
        }

        return (int) (ret % mod);
    }

    boolean isTarget(long num) {
        if ((~num + 1 & num) == num) {
            return true;
        }

        return false;
    }
}
