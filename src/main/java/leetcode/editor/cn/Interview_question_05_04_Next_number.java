package leetcode.editor.cn;

/**
 * @author Nirvana
 * @date 2020/10/24 23:10
 * <p>
 * 面试题 05.04. 下一个数
 * <p>
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 */
public class Interview_question_05_04_Next_number {
    //求数的二进制1的个数
    private static int findOneCount(int num) {
        int count = 0;
        while (num != 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }

    public int[] findClosedNumbers(int num) {
        int up = num + 1;//向上枚举
        int down = num - 1;//向下枚举
        int count = findOneCount(num);//num的1的个数
        while (findOneCount(up) != count) {
            up++;
            if (up < 0) {//越界了那就是找不到，设置为-1
                up = -1;
                break;
            }
        }
        while (findOneCount(down) != count) {
            down--;
            if (down < 0) {//变为负数了那就是找不到了，设置为-1
                down = -1;
                break;
            }
        }
        return new int[]{up, down};
    }
}
