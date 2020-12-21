package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/10/10 9:44 上午
 * @desc 1. 快排改写
 * 2. bfprt 算法
 * <p>
 * <p>
 * 1. 快排改写流程
 * 1.1. 随机选择一个数
 * 1.2. 进行partition
 * 1.3. 对划分区进行匹配, 如果在返回的范围内, 直接返回, 否则递归调用
 * <p>
 * <p>
 * 2. bfprt 算法整个流程和快排改写差不离, 唯一变的地方是选择随机数的时候精挑细选。
 */
public class No_215_Kth_largest_element_in_the_array {
    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 6;

//         3,2,3,1,2,4,5,5,6
//         4
        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;

        int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        return process(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 在 nums[l...r] 找到第k大的数字
     *
     * @param nums
     * @param k
     * @param l
     * @param r
     * @return
     */
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

    @Test
    public void testPartition() {
        int[] nums = new int[]{3, 4, 5, 3, 2, 4, 7, 8, 5, 4, 3, 3, 7, 6, 4, 3, 2, 5, 7, 7, 5, 3, 3, 4, 6, 5, 4, 3, 5, 5};
        int[] partition = partition(nums, 0, nums.length - 1);
        PrintUtils.print(nums);
        PrintUtils.print(partition);
    }
}
