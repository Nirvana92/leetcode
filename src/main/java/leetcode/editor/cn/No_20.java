package leetcode.editor.cn;

import org.junit.Test;

import java.util.Random;
import java.util.Stack;

public class No_20 {
    static String[] strs = new String[]{"(", ")", "[", "]", "{", "}"};

    public static void main(String[] args) {
        No_20 no_20 = new No_20();
        String str = "]]]]]]]]";
        boolean valid = no_20.isValid(str);
        System.out.println(valid);

    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
            }else {
                if(stack.isEmpty()) {
                    return false;
                }
                Character c = stack.pop();
                if((chars[i] == ')' && c == '(')
                        || (chars[i] == '}' && c == '{')
                        || (chars[i] == ']' && c == '[')) {
                    continue;
                }

                return false;
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    @Test
    public void test() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int strLen = random.nextInt(12);

            String str = "";
            while (strLen-- > 0) {
                str += strs[random.nextInt(strs.length)];
            }

            boolean valid = isValid(str);
            System.out.println("strs: "+str+"; "+valid);
        }
    }
}
