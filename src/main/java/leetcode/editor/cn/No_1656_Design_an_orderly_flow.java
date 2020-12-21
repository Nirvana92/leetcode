package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzm
 * @date 2020/11/16 7:53 下午
 * @desc: 1656. 设计有序流
 */
public class No_1656_Design_an_orderly_flow {
    @Test
    public void test() {
        int n = 5;
        OrderedStream orderedStream = new OrderedStream(n);

        List<String> ccccc = orderedStream.insert(3, "ccccc");
        List<String> aaaaa = orderedStream.insert(1, "aaaaa");
        System.out.println(aaaaa);
        List<String> bbbbb = orderedStream.insert(2, "bbbbb");
        System.out.println(bbbbb);
        List<String> eeeee = orderedStream.insert(5, "eeeee");
        System.out.println(eeeee);
        List<String> ddddd = orderedStream.insert(4, "ddddd");
        System.out.println(ddddd);
    }

    class OrderedStream {
        int ptr = 1;
        String[] datas;

        public OrderedStream(int n) {
            datas = new String[n + 1];
        }

        public List<String> insert(int id, String value) {
            List<String> rets = new ArrayList<>();
            datas[id] = value;

            if (ptr == id) {
                // 手机结果集输出
                while (ptr < datas.length && datas[ptr] != null) {
                    rets.add(datas[ptr]);
                    datas[ptr] = null;
                    ptr++;
                }
            }

            return rets;
        }
    }
}
