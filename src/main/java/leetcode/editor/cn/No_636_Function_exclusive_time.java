package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author gzm
 * @date 2020/11/4 5:46 下午
 * @desc: 636. 函数的独占时间
 */
public class No_636_Function_exclusive_time {
    @Test
    public void test() {
        int n = 2;
        List<String> logs = Arrays.asList("0:start:0",
                "1:start:2",
                "1:end:5",
                "0:end:6");

        n = 2;
        logs = Arrays.asList("0:start:0", "1:start:2", "0:start:3", "0:end:4", "1:end:5", "0:end:6");

        n = 3;
        logs = Arrays.asList("0:start:0", "1:start:2", "0:start:3", "2:start:4", "1:start:5", "1:end:6", "2:end:7", "0:end:8", "1:end:10", "0:end:12");

//        n = 1;
//        logs = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");

        int[] exclusiveTime = exclusiveTime(n, logs);
        PrintUtils.print(exclusiveTime);
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] times = new int[n];

        Stack<Integer> stack = new Stack<>();
        int preTs = 0;
        for (int i = 0; i < logs.size(); i++) {
            String[] split = logs.get(i).split(":");
            int funNo = Integer.parseInt(split[0]);
            String startOrEn = split[1];
            int ts = Integer.parseInt(split[2]);
            // 第一次初始化赋值
            if (i == 0) {
                stack.add(funNo);
                preTs = ts;
            } else {
                // 当前函数是开始状态
                if (startOrEn.equals("start")) {
                    if (!stack.isEmpty()) {
                        // 记录之前开始状态的占用时间
                        times[stack.peek()] += ts - preTs;
                    }

                    // 添加当前状态
                    stack.add(funNo);
                    preTs = ts;
                } else {
                    // startorEnd == end
                    // 处理一个函数的开始结束状态的占用时间
                    times[funNo] += ts - preTs + 1;
                    preTs = ts + 1;
                    stack.pop();
                }
            }
        }

        return times;
    }
}
