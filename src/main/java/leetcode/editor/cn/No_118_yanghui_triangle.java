package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class No_118_yanghui_triangle {
    @Test
    public void test() {
        int numRows = 5;
        List<List<Integer>> generate = generate(numRows);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        if (numRows == 0) {
            return results;
        }

        List<Integer> tmpRsts = new ArrayList<>();
        tmpRsts.add(1);
        results.add(tmpRsts);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> tmpRst = new ArrayList<>();
            List<Integer> preRst = results.get(i - 2);

            // 当前层的数字的个数 i, 转化下标的时候 i-1
            for (int j = 0; j < i; j++) {
                int curNum = 0;
                if (j - 1 >= 0) {
                    curNum += preRst.get(j - 1);
                }
                if (j < preRst.size()) {
                    curNum += preRst.get(j);
                }

                tmpRst.add(curNum);
            }

            results.add(tmpRst);
        }

        return results;
    }
}
