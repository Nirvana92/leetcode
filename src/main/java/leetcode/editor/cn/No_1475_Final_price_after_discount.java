package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.Stack;

/**
 * @author gzm
 * @date 2020/10/23 2:59 下午
 * @desc: 1475. 商品折扣后的最终价格
 * <p>
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，
 * 其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 */
public class No_1475_Final_price_after_discount {
    @Test
    public void test() {
        int[] prices = new int[]{8, 4, 6, 2, 3};
        prices = new int[]{1, 2, 3, 4, 5};
        prices = new int[]{10, 1, 1, 6};

        int[] finalPrices = finalPrices(prices);
        PrintUtils.print(finalPrices);
    }

    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int N = prices.length;
        int[] fPrices = new int[N];

        for (int i = 0; i < N; i++) {
            if (stack.isEmpty() || prices[i] > prices[stack.peek()]) {
                stack.add(i);
            } else {
                // i位置的值 小于栈首的值
                // 统计栈首的值
                while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                    Integer index = stack.pop();
                    fPrices[index] = prices[index] - prices[i];
                }

                stack.add(i);
            }
        }

        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            fPrices[index] = prices[index];
        }

        return fPrices;
    }
}
