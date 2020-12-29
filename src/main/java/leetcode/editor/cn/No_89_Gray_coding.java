package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzm
 * @date 2020/12/29 5:31 下午
 * @desc: 89. 格雷编码
 * <p>
 * 参考题解的解决方法
 */
public class No_89_Gray_coding {
    @Test
    public void test() {
        int n = 5;
        List<Integer> lists = grayCodeFinal(n);
        System.out.println(lists);

        List<Integer> list2 = grayCode(n);
        System.out.println(list2);

//        for (Integer num : lists) {
//            System.out.println(Integer.toBinaryString(num));
//        }
    }

    public List<Integer> grayCodeFinal(int n) {
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
            nums.add(i ^ (i >> 1));
        }

        return nums;
    }

    /**
     * 结果集必须要 2^n 个元素
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> nums = new ArrayList<>();

        // 默认是通过0 开始
        nums.add(0);
        // nums.add(1);

        int changeNum = 1;
        for (int i = 0; i < n; i++) {
            changeNum <<= i;

            nums.add(nums.get(nums.size() - 1) ^ changeNum);
        }

        for (int i = 1; i < n; i++) {
            changeNum >>= i;


            nums.add(nums.get(nums.size() - 1) ^ changeNum);
        }

        return nums;
    }
}
