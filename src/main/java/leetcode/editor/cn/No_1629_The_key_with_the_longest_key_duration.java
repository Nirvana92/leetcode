package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/10 4:48 下午
 * @desc: 1629. 按键持续时间最长的键
 */
public class No_1629_The_key_with_the_longest_key_duration {
    @Test
    public void test() {
        int[] releaseTimes = new int[]{9, 29, 49, 50};
        String keysPressed = "cbcd";

        releaseTimes = new int[]{12, 23, 36, 46, 62};
        keysPressed = "spuda";


        char slowestKey = slowestKey(releaseTimes, keysPressed);
        System.out.println(slowestKey);
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {

        int maxSlowestKeyIndex = 0, maxSlowestTime = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int curTime = releaseTimes[i] - releaseTimes[i - 1];
            if (curTime > maxSlowestTime) {
                maxSlowestKeyIndex = i;
                maxSlowestTime = curTime;
            } else if (curTime == maxSlowestTime) {
                if (keysPressed.charAt(i) > keysPressed.charAt(maxSlowestKeyIndex)) {
                    maxSlowestKeyIndex = i;
                }
            }
        }

        return keysPressed.charAt(maxSlowestKeyIndex);
    }
}
