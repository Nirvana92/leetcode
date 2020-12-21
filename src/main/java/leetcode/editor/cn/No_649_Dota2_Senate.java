package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gzm
 * @date 2020/12/11 9:32 上午
 * @desc: 649. Dota2 参议院
 */
public class No_649_Dota2_Senate {
    @Test
    public void test() {
        String senate = "RD";
        String predictPartyVictory = predictPartyVictory(senate);
        System.out.println(predictPartyVictory);
    }

    public String predictPartyVictory(String senate) {
        int N = senate.length();
        Queue<Integer> rQueues = new LinkedList<>(), dQueues = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (senate.charAt(i) == 'R') {
                rQueues.add(i);
            } else {
                dQueues.add(i);
            }
        }

        while (!rQueues.isEmpty() && !dQueues.isEmpty()) {
            Integer rIndex = rQueues.poll();
            Integer dIndex = dQueues.poll();

            if (rIndex < dIndex) {
                rQueues.add(rIndex + N);
            } else {
                dQueues.add(dIndex + N);
            }
        }

        return rQueues.isEmpty() ? "Dire" : "Radiant";
    }
}
