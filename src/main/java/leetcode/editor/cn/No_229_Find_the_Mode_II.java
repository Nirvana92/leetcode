package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

/**
 * @author gzm
 * @date 2020/10/15 2:21 下午
 * @desc: 血王问题进阶
 * <p>
 * 229. 求众数 II
 * <p>
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 */
public class No_229_Find_the_Mode_II {
    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 3, 3};
        nums = new int[]{3, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 23, 2, 2, 233, 2, 23, 23, 23, 32, 32, 443, 4, 4, 4, 43, 43, 43, 34, 3, 32, 23, 2, 12, 23, 4};
        List<Integer> integers = majorityElement(nums);
        System.out.println(integers);
    }

    /**
     * 求所有出现超过 n/3 的元素, 一个数组中最多只有有三个这种元素
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        // PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> resutls = new ArrayList<>();
        int K = 3;
        Map<Integer, Integer> countMaps = new HashMap<>();
        // 遍历, 统计每个数的出现次数
        for (int num : nums) {
            // 如果容器中的大小小于K, 则往容器中添加
            if (countMaps.size() < K) {
                countMaps.put(num, countMaps.getOrDefault(num, 0) + 1);
            } else {
                // 容器中的元素全部减掉1 点血量
                // 如果容器已经满了, 则丢弃掉需要添加的元素, 然后容器中的所有元素出现的次数全部-1
                for (Iterator<Map.Entry<Integer, Integer>> entry = countMaps.entrySet().iterator(); entry.hasNext(); ) {
                    Map.Entry<Integer, Integer> next = entry.next();
                    int remindCount = next.getValue() - 1;
                    if (remindCount <= 0) {
                        entry.remove();
                    } else {
                        countMaps.put(next.getKey(), remindCount);
                    }
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : countMaps.entrySet()) {
            countMaps.put(entry.getKey(), 0);
        }

        // 因为集合中的元素不一定是最后的结果答案, 所以需要重新统计下待确定的元素是否满足要求
        for (int num : nums) {
            int curNumCount = countMaps.getOrDefault(num, 0) + 1;
            countMaps.put(num, curNumCount);
        }

        for (Map.Entry<Integer, Integer> entry : countMaps.entrySet()) {
            if (entry.getValue() > nums.length / K) {
                resutls.add(entry.getKey());
            }
        }

        return resutls;
    }
}
