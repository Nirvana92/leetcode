package leetcode.editor.cn;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Nirvana
 * @date 2020/10/19 00:02
 * <p>
 * 1130. 叶值的最小代价生成树
 * <p>
 * 使用单调栈求解, 单调栈. 小压大
 */
public class No_1130_Minimum_cost_spanning_tree {
    @Test
    public void test() {
        int[] arr = new int[]{6, 2, 4};

        arr = new int[]{6, 4, 3, 2};

        arr = new int[]{56, 23, 48, 23, 56, 56, 47};

        arr = new int[]{56, 23, 48, 23, 56, 56, 47, 98, 100};

        int mctFromLeafValues = mctFromLeafValues(arr);
        System.out.println(mctFromLeafValues);
    }

    public int mctFromLeafValues(int[] arr) {
        int minMctVals = 0;
        Stack<Integer> stacks = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stacks.isEmpty() || arr[i] < stacks.peek()) {
                stacks.add(arr[i]);
            } else {
                while (!stacks.isEmpty() && arr[i] > stacks.peek()) {
                    // 需要计算的值
                    Integer popVal = stacks.pop();
                    if (stacks.isEmpty() || arr[i] < stacks.peek()) {
                        minMctVals += popVal * arr[i];
                    } else {
                        minMctVals += popVal * stacks.peek();
                    }
                }
                stacks.add(arr[i]);
            }
        }

        while (!stacks.isEmpty()) {
            Integer popVal = stacks.pop();

            if (!stacks.isEmpty()) {
                minMctVals += popVal * stacks.peek();
            }
        }

        return minMctVals;
    }
}
