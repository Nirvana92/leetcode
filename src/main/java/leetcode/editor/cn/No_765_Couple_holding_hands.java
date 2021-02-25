package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2021/2/14 20:46
 * <p>
 * <p>
 * 765. 情侣牵手
 * 并查集
 */
public class No_765_Couple_holding_hands {
    int[] p = new int[70];

    @Test
    public void test() {
        int[] row = new int[]{0, 2, 1, 3};
        row = new int[]{3, 2, 0, 1};

        int minSwapsCouples = minSwapsCouples(row);
        System.out.println(minSwapsCouples);
    }

    public int find(int a) {
        if (p[a] != a) {
            p[a] = find(p[a]);
        }

        return p[a];
    }

    public void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    public int minSwapsCouples(int[] row) {
        int len = row.length;

        for (int i = 0; i < len / 2; i++) {
            p[i] = i;
        }

        for (int i = 0; i < len; i += 2) {
            union(row[i] / 2, row[i + 1] / 2);
        }

        int num = 0;

        for (int i = 0; i < len / 2; i++) {
            if (i == p[i]) {
                num++;
            }
        }

        return len / 2 - num;
    }
}
