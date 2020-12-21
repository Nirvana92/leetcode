package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * version1=1.01
 * version2=1.0001 预期结果是0
 */
public class No_165_Compare_version_numbers {
    @Test
    public void test() {
        String version1 = "1.01.1", version2 = "1.0001";
        int compareVersion = compareVersion(version1, version2);
        System.out.println(compareVersion);

//        String version = "23";
//        int indexOf = version.indexOf(".");
//        System.out.println(indexOf);
    }

    public int compareVersion(String version1, String version2) {
        int ver1FirstIndex = version1.indexOf(".");
        String ver1Head = ver1FirstIndex == -1 ? version1 : version1.substring(0, ver1FirstIndex);

        int ver2FirstIndex = version2.indexOf(".");
        String ver2Head = ver2FirstIndex == -1 ? version2 : version2.substring(0, ver2FirstIndex);

        char[] ver1s = removeHeadZero(ver1Head);
        char[] ver2s = removeHeadZero(ver2Head);

        for (int i = 0; i < Math.min(ver1s.length, ver2s.length); i++) {
            if (ver1s[i] > ver2s[i]) {
                return 1;
            } else if (ver1s[i] < ver2s[i]) {
                return -1;
            }
        }

        if (ver1s.length != ver2s.length) {
            if (ver1s.length > ver2s.length) {
                return 1;
            }

            if (ver1s.length < ver2s.length) {
                return -1;
            }
        }

        version1 = ver1FirstIndex == -1 ? "" : version1.substring(ver1FirstIndex + 1);
        version2 = ver2FirstIndex == -1 ? "" : version2.substring(ver2FirstIndex + 1);
        return (ver1FirstIndex == -1 && ver2FirstIndex == -1) ? 0 : compareVersion(version1, version2);
    }

    public char[] removeHeadZero(String version) {
        char[] chars = version.toCharArray();
        int firstIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                firstIndex = i;
                break;
            }
        }

        return Arrays.copyOfRange(chars, firstIndex, chars.length);
    }
}
