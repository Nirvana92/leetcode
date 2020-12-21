package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nirvana
 * @date 2020/10/21 22:51
 * <p>
 * 691. 贴纸拼词: 同org.nirvana.dp.StickerStr
 */
public class No_691_Sticker_spelling {
    @Test
    public void test() {
        String[] stickers = new String[]{"with", "example", "science"};
        String target = "thehat";
        int minStickers = minStickers(stickers, target);
        System.out.println(minStickers);
    }

    public int minStickers(String[] stickers, String target) {
        int N = stickers.length;
        // 贴纸中每个字符出现的次数
        int[][] stickerMaps = new int[N][26];
        for (int i = 0; i < N; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerMaps[i][c - 'a']++;
            }
        }
        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        return process(stickerMaps, target, dp);
    }

    /**
     * @param stickerMaps: 贴纸数组
     * @param rest:        剩余的待填充的字符及其个数
     * @return: 返回需要的最小贴纸数
     */
    int process(int[][] stickerMaps, String rest, Map<String, Integer> dp) {
//        if (rest.length() == 0) {
//            return 0;
//        }

        if (dp.containsKey(rest)) {
            return dp.get(rest);
        }

        // 当前贴纸使用的次数遍历
        int N = stickerMaps.length;
        int[] restMaps = new int[26];
        for (char r : rest.toCharArray()) {
            restMaps[r - 'a']++;
        }

        int minSticker = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int[] sticker = stickerMaps[i];

            if (sticker[rest.charAt(0) - 'a'] == 0) {
                continue;
            }

            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < 26; j++) {
                if (restMaps[j] > 0) {
                    for (int r = 0; r < Math.max(0, restMaps[j] - sticker[j]); r++) {
                        buffer.append((char) ('a' + j));
                    }
                }
            }

            int nextStickers = process(stickerMaps, buffer.toString(), dp);
            if (nextStickers != -1) {
                minSticker = Math.min(minSticker, nextStickers + 1);
            }
        }

        dp.put(rest, minSticker == Integer.MAX_VALUE ? -1 : minSticker);
        return dp.get(rest);
    }
}
