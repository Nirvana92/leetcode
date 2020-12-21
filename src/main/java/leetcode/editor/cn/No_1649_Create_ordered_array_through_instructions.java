package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/9 22:18
 * <p>
 * 1649. 通过指令创建有序数组
 * <p>
 * 树状数组实现
 */
public class No_1649_Create_ordered_array_through_instructions {
    @Test
    public void test() {
        int[] ins = new int[]{1, 5, 6, 2};
        ins = new int[]{1, 2, 3, 6, 5, 4};
        ins = new int[]{1, 3, 3, 3, 2, 4, 2, 1, 2};

        int sortedArray = createSortedArray(ins);
        System.out.println(sortedArray);
    }

    /**
     * 将 ins[i] 作为下标, 值为1.这样就可以求k的值小于的个数和大于的个数。然后快速求出最小操作数
     *
     * @param instructions
     * @return
     */
    public int createSortedArray(int[] instructions) {
        int MOD = (int) (1e9 + 7);
        IndexTree indexTree = new IndexTree((int) (1e5 + 1));

        long minOpera = 0;
        for (int i = 0; i < instructions.length; i++) {
            long minCounts = indexTree.sum(instructions[i] - 1);
            long maxCounts = i - indexTree.sum(instructions[i]);

            minOpera = (minOpera + Math.min(minCounts, maxCounts)) % MOD;

            indexTree.add(instructions[i], 1);
        }

        return (int) minOpera;
    }

    class IndexTree {
        private int[] tree;
        private int N;

        public IndexTree(int size) {
            this.N = size;
            tree = new int[N + 1];
        }

        public int sum(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }

            return sum;
        }

        public void add(int index, int d) {
            while (index <= N) {
                tree[index] += d;
                index += index & -index;
            }
        }
    }
}
