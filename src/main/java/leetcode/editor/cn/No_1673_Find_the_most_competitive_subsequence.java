package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.LinkedList;

/**
 * @author gzm
 * @date 2020/12/16 3:24 下午
 * @desc: 1673. 找出最具竞争力的子序列
 * <p>
 * 滑动窗口
 */
public class No_1673_Find_the_most_competitive_subsequence {
    @Test
    public void test() {
        int[] nums = new int[]{3, 5, 2, 6};
        int k = 2;

//        nums = new int[]{2, 4, 3, 3, 5, 4, 9, 6, 1, 1};
//        // nums = new int[]{2, 4, 3, 3, 5, 4, 9, 6};
//        k = 4;

        int[] mostCompetitive = mostCompetitive(nums, k);
        PrintUtils.print(mostCompetitive);
    }

//    @Test
//    public void t() {
//        int times = 1000000;
//
//        while (times-- > 0) {
//            int[] nums = Utils.generIntArr(1, 20, 1, 200);
//            int k = Utils.generInt(1, nums.length);
//
//            int[] rets = mostCompetitive(nums, k);
//            int[] mostCompetitiveLogarithm = mostCompetitiveLogarithm(nums, k);
//
//            if (rets.length != mostCompetitiveLogarithm.length) {
//                System.out.println("error");
//                break;
//            }
//
//            for (int i = 0; i < rets.length; i++) {
//                if (rets[i] != mostCompetitiveLogarithm[i]) {
//                    System.out.println("error");
//                    break;
//                }
//            }
//        }
//    }

    public int[] mostCompetitive(int[] nums, int k) {
        int[] rets = new int[k];
        int N = nums.length;
        LinkedList<Integer> lists = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            while (!lists.isEmpty() && nums[lists.peekLast()] > nums[i] && (N - i - 1 + lists.size()) >= k) {
                lists.pollLast();
            }

            lists.addLast(i);
        }

        for (int i = 0; i < k; i++) {
            rets[i] = nums[lists.pollFirst()];
        }

        return rets;
    }
}
