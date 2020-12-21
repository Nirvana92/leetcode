package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/21 00:12
 * <p>
 * 925. 长按键入
 * <p>
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 */
public class No_925_Long_press_to_enter {
    @Test
    public void test() {
        String name = "alex", typed = "aaleex";

        name = "saeed";
        typed = "ssaaedd";

        name = "leelee";
        typed = "lleeelee";

        name = "laiden";
        typed = "laiden";

        name = "laiden";
        typed = "llaide";

        boolean longPressedName = isLongPressedName(name, typed);
        System.out.println(longPressedName);
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name.length() == 0) {
            return typed.length() == 0;
        }

        int nameIndex = 0, typedIndex = 0;

        while (nameIndex < name.length() && typedIndex < typed.length()) {
            if (name.charAt(nameIndex) == typed.charAt(typedIndex)) {
                nameIndex++;
                typedIndex++;
            } else {
                if (nameIndex > 0 && typed.charAt(typedIndex) == name.charAt(nameIndex - 1)) {
                    typedIndex++;
                } else {
                    return false;
                }
            }
        }

        if (nameIndex != name.length()) {
            return false;
        }

        while (typedIndex < typed.length() && typed.charAt(typedIndex) == name.charAt(nameIndex - 1)) {
            typedIndex++;
        }

        return typedIndex == typed.length();
    }
}
