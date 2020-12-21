package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/12/16 22:59
 */
public class No_1678_Design_the_Goal_parser {
    @Test
    public void test() {
        String command = "G()(al)";
        command = "G()()()()(al)";
        command = "(al)G(al)()()G";

        String interpret = interpret(command);
        System.out.println(interpret);
    }

    public String interpret(String command) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == '(') {
                // 找到最近的 ')'
                if (command.charAt(i + 1) == ')') {
                    buffer.append('o');
                    i++;
                }

            } else if (command.charAt(i) == ')') {
                continue;
            } else {
                buffer.append(command.charAt(i));
            }
        }

        return buffer.toString();
    }
}
