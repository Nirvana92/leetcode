package leetcode.editor.cn;

/**
 * @author Nirvana
 * @date 2021/1/1 17:28
 * <p>
 * 605. 种花问题
 */
public class No_605_Flower_problem {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int places = 0;
        boolean prePlaced = false;
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 1) {
                n -= prePlaced ? (places % 2 == 1 ? places / 2 : (places - 1) / 2) : places / 2;
                places = 0;
                prePlaced = true;
            } else {
                places++;
            }
        }

        if (places > 0) {
            n -= prePlaced ? places / 2 : (places + 1) / 2;
        }

        if (n <= 0) {
            return true;
        }

        return false;
    }
}
