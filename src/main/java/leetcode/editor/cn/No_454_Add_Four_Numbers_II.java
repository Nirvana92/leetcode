package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nirvana
 * @date 2020/11/2 22:31
 * <p>
 * 参考: https://leetcode-cn.com/problems/4sum-ii/solution/454-si-shu-xiang-jia-iimapzai-ha-xi-fa-zhong-de-yi/
 */
public class No_454_Add_Four_Numbers_II {
    @Test
    public void test() {

    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                //A[i] + B[j];
                counts.put(A[i] + B[j], counts.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        int results = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (counts.containsKey(-C[i] - D[j])) {
                    results += counts.get(-C[i] - D[j]);
                }
            }
        }

        return results;
    }
}
