package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author gzm
 * @date 2020/12/24 8:09 下午
 * @desc: 284. 顶端迭代器
 */
public class No_284_Top_iterator {
    @Test
    public void test() {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        PeekingIterator peekingIterator = new PeekingIterator(nums.iterator());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.hasNext());
    }

    class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> iterator = null;
        // 记录上一次peek的值和 prePeekVal
        boolean prePeekOperation = false;
        Integer prePeekVal = null;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (prePeekOperation) {
                return prePeekVal;
            }

            if (hasNext()) {
                prePeekVal = iterator.next();
                prePeekOperation = true;

                return prePeekVal;
            }

            return null;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (prePeekOperation) {
                prePeekOperation = false;
                return prePeekVal;
            }

            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext() || prePeekOperation;
        }
    }
}
