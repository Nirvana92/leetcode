package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2020/9/15 7:56 下午
 * @desc
 */
public class No_76 {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Map<Character, Integer> tCountMap = new HashMap<>();
        // 填充字符个数对应表
        int maxMatchCharCount = ts.length;
        for (char c : ts) {
            tCountMap.put(c, tCountMap.getOrDefault(c, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int minLIndex = 0, minRIndex = 0;
        int lIndex = -1, rIndex = 0;
        while (rIndex < ss.length) {
            if (maxMatchCharCount <= 0) {
                // 欠债表中的字符串都消费完了, 可以统计一个结果了, 此时lIndex 需要向右移动
                char tmpChar = ss[lIndex];
                if (tCountMap.containsKey(tmpChar)) {
                    if (tCountMap.put(tmpChar, tCountMap.get(tmpChar) + 1) == 0) {
                        maxMatchCharCount++;
                    }
                }
            } else {
                // 欠债表中的字符还有没被消费的, 需要rIndex 向右移动
                char tmpChar = ss[rIndex];
                if (tCountMap.containsKey(tmpChar)) {
                    if (tCountMap.put(tmpChar, tCountMap.get(tmpChar) - 1) > 0) {
                        maxMatchCharCount--;
                    }
                }
            }

            if (maxMatchCharCount == 0) {
                // 计算
                if (rIndex - lIndex + 1 < minLen) {
                    minLen = rIndex - lIndex + 1;
                    minLIndex = lIndex + 1;
                    minRIndex = rIndex;
                }

                lIndex++;
            } else {
                rIndex++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (int index = minLIndex; index <= minRIndex; index++) {
            builder.append(ss[index]);
        }
        return builder.toString();
    }

    @Test
    public void test() {
        // String s = "ADOBECODEBANC", t = "ABC";
        String s = "ADOBEODEN", t = "ABC";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }
}
