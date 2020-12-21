package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author gzm
 * @date 2020/12/8 9:30 上午
 * @desc: 842. 将数组拆分成斐波那契序列
 */
public class No_842_Split_the_array_into_Fibonacci_series {
    @Test
    public void test() {
        String s = "123456579";
        s = "11235813";
        s = "112358130";
        s = "0123";
//        s = "1101111";
//        s = "539834657215398346785398346991079669377161950407626991734534318677529701785098211336528511";
//        s = "044";
        s = "5280060";
        s = "1304";
        s = "000";
        s = "00027052831550";

//        List<Integer> retss = splitIntoFibonacci(s);
//        List<Integer> list = splitIntoFibonacciGuanfang(s);
//        System.out.println(retss);
//        System.out.println(list);

        int times = 1000000;
        while (times-- > 0) {
            int len = Utils.generInt(1, 200);
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < len; i++) {
                buffer.append(Utils.generInt(0, 9));
            }

            List<Integer> rets = splitIntoFibonacci(buffer.toString());
            List<Integer> list = splitIntoFibonacciGuanfang(buffer.toString());

            if (rets.size() != list.size()) {
                System.out.println(buffer.toString());
                System.out.println("====error");
            } else {
                for (int i = 0; i < rets.size(); i++) {
                    if (!Objects.equals(rets.get(i), list.get(i))) {
                        System.out.println("错误");
                    }
                }
            }
        }
    }

    /**
     * 从字符串第一个字符开始尝试找数字
     *
     * @param s
     * @return
     */
    public List<Integer> splitIntoFibonacci(String s) {
        List<Integer> rets = new ArrayList<>();
        process(s, 0, rets);

        return rets;
    }

    boolean process(String s, int index, List<Integer> rets) {
        int N = s.length();
        if (index == N) {
            return rets.size() > 2;
        }

        if (s.charAt(index) == '0') {
            if (rets.size() < 2) {
                // 当前的数字为 0. 当前数字只能独立设置一个数字
                rets.add(0);
                boolean ret = process(s, index + 1, rets);

                if (!ret) {
                    // 没有成功, 移除最后一个位置的数字
                    rets.remove(rets.size() - 1);
                }

                return ret;
            }

            boolean ret = (0 == rets.get(rets.size() - 1) + rets.get(rets.size() - 2));

            if (ret) {
                rets.add(0);
                boolean nextRet = process(s, index + 1, rets);
                if (!nextRet) {
                    rets.remove(rets.size() - 1);
                    return false;
                }
            }
            return ret;
        }

        for (int endIndex = index; endIndex < N - Math.max(0, 2 - rets.size()); endIndex++) {
            long curNum = Long.parseLong(s.substring(index, endIndex + 1));
            if (curNum > Integer.MAX_VALUE || (rets.size() >= 2 && curNum - rets.get(rets.size() - 1) > rets.get(rets.size() - 2))) {
                break;
            }

            if (rets.size() < 2 || curNum - rets.get(rets.size() - 1) == rets.get(rets.size() - 2)) {
                rets.add((int) curNum);
                boolean processRet = process(s, endIndex + 1, rets);
                if (!processRet) {
                    rets.remove(rets.size() - 1);
                } else {
                    return rets.size() > 2;
                }
            }
        }

        return false;
    }


    public List<Integer> splitIntoFibonacciGuanfang(String S) {
        List<Integer> list = new ArrayList<Integer>();
        backtrack(list, S, S.length(), 0, 0, 0);
        return list;
    }

    public boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev) {
        if (index == length) {
            return list.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {
            if (i > index && S.charAt(index) == '0') {
                break;
            }
            currLong = currLong * 10 + S.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int) currLong;
            if (list.size() >= 2) {
                if (curr < sum) {
                    continue;
                } else if (curr > sum) {
                    break;
                }
            }
            list.add(curr);
            if (backtrack(list, S, length, i + 1, prev + curr, curr)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
