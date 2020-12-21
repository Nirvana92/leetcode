package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nirvana
 * @date 2020/11/3 23:25
 * <p>
 * 535. TinyURL 的加密与解密[参考官方解法]
 */
public class No_535_Encryption_and_decryption_of_TinyURL {
    Map<Integer, String> map = new HashMap<>();
    int i = 0;

    public String encode(String longUrl) {
        map.put(i, longUrl);
        return "http://tinyurl.com/" + i++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}
