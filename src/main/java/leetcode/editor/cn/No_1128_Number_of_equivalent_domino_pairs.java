package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2021/1/26 9:01 上午
 * @desc: 1128. 等价多米诺骨牌对的数量
 */
public class No_1128_Number_of_equivalent_domino_pairs {
    @Test
    public void test() {
        int[][] dominoes = new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}};

        int numEquivDominoPairs = numEquivDominoPairs(dominoes);
        System.out.println(numEquivDominoPairs);
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> countMaps = new HashMap<>();

        int tmpNum = 0;
        for (int i = 0; i < dominoes.length; i++) {
            tmpNum = dominoes[i][0] > dominoes[i][1] ? dominoes[i][0] * 10 + dominoes[i][1] : dominoes[i][1] * 10 + dominoes[i][0];

            countMaps.put(tmpNum, countMaps.getOrDefault(tmpNum, 0) + 1);
        }

        int resultNum = 0;
        int tmpCouns = 0;
        for (Map.Entry<Integer, Integer> entry : countMaps.entrySet()) {
            tmpCouns = entry.getValue();
            if (tmpCouns > 1) {
                resultNum += tmpCouns * (tmpCouns - 1) / 2;
            }
        }

        return resultNum;
    }
}
