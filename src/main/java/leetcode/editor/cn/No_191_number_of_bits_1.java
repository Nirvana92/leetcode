package leetcode.editor.cn;

public class No_191_number_of_bits_1 {
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int numOfBits1 = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                numOfBits1++;
            }
            n >>>= 1;
        }

        return numOfBits1;
    }
}
