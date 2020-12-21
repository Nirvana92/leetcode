package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/4 23:14
 * <p>
 * 378. 有序矩阵中第K小的元素
 */
public class No_378_K_th_smallest_element_in_an_ordered_matrix {
    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {1, 5, 9},
                {2, 6, 10},
                {3, 7, 12}
        };
        int k = 7;
        int kthSmallest = kthSmallest(matrix, k);
        System.out.println(kthSmallest);
    }

    public int kthSmallest(int[][] matrix, int k) {
        int N = matrix.length;
        //int firstIndex = (N * (N - 1)) / 2;
        // 1 ~ firstIndex
        // firstIndex + 1 ~ firstIndex + N
        // firstIndex + N ~ N*N
        //int preSum = 0;
        boolean findIndex = false;
        int index = 0, tmpK = k;
        for (int i = 1; i <= N; i++) {
            index++;
            // i ~ i + i-1
            if (tmpK >= 1 && tmpK <= i) {
                //tmpK -= i;
                findIndex = true;
                break;
            }
            tmpK -= i;
        }

        if (!findIndex) {
            for (int i = N - 1; i > 0; i--) {
                index++;
                if (tmpK >= 1 && tmpK <= i) {
                    break;
                }
                tmpK -= i;
            }
        }

        int row = index >= N ? N - 1 : index - 1;
        int col = index >= N ? index - N : 0;

        int len = Math.min(row + 1, N - col);
        int[] arrs = new int[len];
        for (int i = 0; i < len; i++) {
            arrs[i] = matrix[row - i][col + i];
        }

        // 下面就是在arrs 中找第 tmpK 小的数, 改写快排的方法处理
        int result = process(arrs, 0, len - 1, tmpK - 1);
        return result;
    }

    int process(int[] nums, int l, int r, int k) {
        // 1. 随机选择一个数
        int randomIndex = l + (int) (Math.random() * (r - l + 1));
        // 将选中的位置数交换到 r位置
        swap(nums, randomIndex, r);
        // 2. partition 过程
        int[] partition = partition(nums, l, r);
        // 3. 判断范围
        if (partition[0] <= k && partition[1] >= k) {
            return nums[k];
        } else if (partition[0] > k) {
            return process(nums, l, partition[0] - 1, k);
        } else {
            // partition[1] < k
            return process(nums, partition[1] + 1, r, k);
        }
    }

    /**
     * partition 的过程, 将小于randomNum 的数放在左边, 大于randomNum 的数放在右边, 等于randomNum 的数放在中间
     * 每次的比较过程是移动的下标和最后一个下标对比, 即cur 和 r 下标对比
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    int[] partition(int[] nums, int l, int r) {
        // 过滤条件
        if (l > r) {
            return new int[]{-1, -1};
        }

        if (l == r) {
            return new int[]{l, l};
        }


        int cur = l, lIndex = l - 1, rIndex = r;
        while (cur < rIndex) {
            if (nums[cur] > nums[r]) {
                swap(nums, cur, --rIndex);
            } else if (nums[cur] == nums[r]) {
                cur++;
            } else {
                // nums[cur] < nums[r]
                swap(nums, ++lIndex, cur++);
            }
        }

        // 将位于 r的标杆数据交换到同一区域中
        swap(nums, rIndex, r);

        return new int[]{lIndex + 1, rIndex};
    }

    public void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
