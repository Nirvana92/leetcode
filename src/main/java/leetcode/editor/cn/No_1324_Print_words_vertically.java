package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nirvana
 * @date 2020/11/7 22:36
 * <p>
 * 1324. 竖直打印单词
 */
public class No_1324_Print_words_vertically {
    @Test
    public void test() {
        String s = "HOW ARE YOU";
        s = "TO BE OR NOT TO BE";
        s = "CONTEST IS COMING";

        List<String> strings = printVertically(s);
        System.out.println(strings);
    }

    public List<String> printVertically(String s) {
        String[] strs = s.split(" ");

        int maxLen = 0;
        for (String str : strs) {
            maxLen = Math.max(maxLen, str.length());
        }
        // StringBuffer[] bufferArrs = new StringBuffer[maxLen];
        List<String> rets = new ArrayList<>();

        for (int i = 0; i < maxLen; i++) {
            StringBuffer buffer = new StringBuffer();

            int firstToTailSpaceIndex = -1;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() < i + 1) {
                    buffer.append(" ");
                    if (firstToTailSpaceIndex == -1) {
                        firstToTailSpaceIndex = j;
                    }
                } else {
                    buffer.append(strs[j].charAt(i));
                    firstToTailSpaceIndex = -1;
                }
            }


            rets.add(firstToTailSpaceIndex == -1 ? buffer.toString() : buffer.substring(0, firstToTailSpaceIndex));
        }

        return rets;
    }
}
