package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class No_412_Fizz_Buzz {
    @Test
    public void test() {

    }

    public List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0) {
                results.add("Fizz");
                continue;
            }

            if (i % 5 == 0) {
                results.add("Buzz");
                continue;
            }

            results.add(String.valueOf(i));
        }

        return results;
    }
}
