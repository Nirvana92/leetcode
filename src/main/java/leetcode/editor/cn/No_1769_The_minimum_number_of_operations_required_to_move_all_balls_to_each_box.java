package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author Nirvana
 * @date 2021/3/1 22:18
 * <p>
 * 1769. 移动所有球到每个盒子所需的最小操作数
 */
public class No_1769_The_minimum_number_of_operations_required_to_move_all_balls_to_each_box {
    @Test
    public void test() {
        String boxes = "110";
        boxes = "001011";

        int[] minOperations = minOperations(boxes);
        PrintUtils.print(minOperations);
    }

    /**
     * 这边可以优化, 只保留lefts 的数组遍历两遍。即在第二次遍历的时候顺便求出结果
     *
     * @param boxes
     * @return
     */
    public int[] minOperations(String boxes) {
        int[] results = new int[boxes.length()];
        int[] lefts = new int[boxes.length()];
        int[] rights = new int[boxes.length()];
        // 计算从左到右移动到某一个位置的操作数
        int oneNums = boxes.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < boxes.length(); i++) {
            lefts[i] = lefts[i - 1] + oneNums;
            oneNums += boxes.charAt(i) == '1' ? 1 : 0;
        }
        // 在计算从右到左移动到某一个位置的操作数
        oneNums = boxes.charAt(boxes.length() - 1) == '1' ? 1 : 0;
        for (int i = boxes.length() - 2; i >= 0; i--) {
            rights[i] = rights[i + 1] + oneNums;
            oneNums += boxes.charAt(i) == '1' ? 1 : 0;
        }
        // 最后合并两边的答案。求得最终的结果集
        for (int i = 0; i < boxes.length(); i++) {
            results[i] = lefts[i] + rights[i];
        }

        return results;
    }
}
