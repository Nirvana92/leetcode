package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/11/11 10:39 上午
 * @desc: 1641. 统计字典序元音字符串的数目
 */
public class No_1641_Count_the_number_of_lexicographic_vowel_strings {


    /**
     * 隔板法
     *
     * @param n
     * @return
     */
    public int countVowelStrings(int n) {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }
}
