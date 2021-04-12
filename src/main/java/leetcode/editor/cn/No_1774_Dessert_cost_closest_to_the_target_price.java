package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/3/3 9:44 上午
 * @desc: 1774. 最接近目标价格的甜点成本
 */
public class No_1774_Dessert_cost_closest_to_the_target_price {
    @Test
    public void test() {
        int[] baseCosts = new int[]{};
        int[] toppingCosts = new int[]{};
        int target = 4;

        int closestCost = closestCost(baseCosts, toppingCosts, target);
        System.out.println(closestCost);
    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        return -1;
    }
}
