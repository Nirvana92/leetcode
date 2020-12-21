package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Nirvana
 * @date 2020/11/6 23:25
 * <p>
 * 394. 字符串解码
 */
public class No_394_String_decoding {
    @Test
    public void test() {
        String s = "3[a]2[bc]";
        s = "3[a2[c]]";
        s = "2[abc]3[cd]ef";
        s = "abc3[cd]xyz";
        s = "100[leetcode]";

        String decodeString = decodeString(s);
        System.out.println(decodeString);
    }

    public String decodeString(String s) {
        LinkedList<String> numStacks = new LinkedList<>();
        LinkedList<Character> stack = new LinkedList<>();
        StringBuffer preNum = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                // 结算[] 内的内容
                StringBuffer buffer = new StringBuffer();
                while (stack.peekLast() != '[') {
                    buffer.append(stack.pollLast());
                }

                stack.pollLast();

                String loopNum = numStacks.pollLast();
                for (int k = 0; k < loopNum.length(); k++) {
                    stack.pollLast();
                }
                // int loopNum = stack.pollLast() - '0';
                for (int j = 0; j < Integer.parseInt(loopNum); j++) {
                    for (int bufferIndex = buffer.length() - 1; bufferIndex >= 0; bufferIndex--) {
                        stack.addLast(buffer.charAt(bufferIndex));
                    }
                }
            } else {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    preNum.append(s.charAt(i));
                } else if (s.charAt(i) == '[') {
                    numStacks.addLast(preNum.toString());
                    preNum = new StringBuffer();
                } else {
                    preNum = new StringBuffer();
                }
                stack.addLast(s.charAt(i));
            }
        }

        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()) {
            buffer.append(stack.pollFirst());
        }

        return buffer.toString();
    }

//    String process(char[] str, int index) {
//        StringBuffer buffer = new StringBuffer();
//
//        int curIndex = index;
//        while (str[curIndex] != '[') {
//            curIndex++;
//        }
//
//        // curIndex 为'[' 的下标的位置
//        int loopNum = str[curIndex - 1] - '0';
//        if (curIndex > index - 1) {
//            // 说明当前找到的 '[' 位置之前有存在的单独的字符
//            buffer.append(Arrays.copyOfRange(str, index, curIndex - 1));
//        }
//
//        // 找重复的位置
//        // startIndex 是[] 内的第一个字符
//        int startIndex = curIndex + 1, endIndex = curIndex + 1;
//        while (str[endIndex] != ']') {
//            endIndex++;
//        }
//    }
}
