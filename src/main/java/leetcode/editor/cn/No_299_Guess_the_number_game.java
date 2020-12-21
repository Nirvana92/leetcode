package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2020/11/5 5:06 下午
 * @desc: 299. 猜数字游戏
 * <p>
 * 记账本
 */
public class No_299_Guess_the_number_game {
    @Test
    public void test() {
        String secret = "1807", guess = "7810";

        secret = "1123";
        guess = "0111";

        String hint = getHint(secret, guess);
        System.out.println(hint);
    }

    public String getHint(String secret, String guess) {
        Map<Character, Integer> secretMaps = new HashMap<>();
        int N = secret.length();

        int A = 0, B = 0;
        for (int i = 0; i < N; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                secretMaps.put(secret.charAt(i), secretMaps.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            if (secret.charAt(i) != guess.charAt(i) && secretMaps.containsKey(guess.charAt(i))) {
                B++;
                int counts = secretMaps.get(guess.charAt(i));
                if (counts == 1) {
                    secretMaps.remove(guess.charAt(i));
                } else {
                    secretMaps.put(guess.charAt(i), counts - 1);
                }
            }
        }

        return A + "A" + B + "B";
    }
}
