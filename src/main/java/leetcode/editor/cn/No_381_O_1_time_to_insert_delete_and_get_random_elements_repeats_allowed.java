package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

/**
 * @author Nirvana
 * @date 2020/10/31 00:07
 * <p>
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 */
public class No_381_O_1_time_to_insert_delete_and_get_random_elements_repeats_allowed {
    @Test
    public void test() {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(0);
        randomizedCollection.insert(1);
        randomizedCollection.remove(0);
        randomizedCollection.insert(2);
        randomizedCollection.remove(1);
        int random = randomizedCollection.getRandom();
        System.out.println(random);

//        RandomizedCollection randomizedCollection = new RandomizedCollection();
//        randomizedCollection.insert(1);
//        randomizedCollection.insert(1);
//        randomizedCollection.insert(2);
//        randomizedCollection.insert(1);
//        randomizedCollection.insert(2);
//        randomizedCollection.insert(2);
//
//        randomizedCollection.remove(1);
//        randomizedCollection.remove(2);
//        randomizedCollection.remove(2);
//        randomizedCollection.remove(2);
//
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());

//        RandomizedCollection randomizedCollection = new RandomizedCollection();
//        randomizedCollection.insert(10);
//        randomizedCollection.insert(10);
//        randomizedCollection.insert(20);
//        randomizedCollection.insert(20);
//        randomizedCollection.insert(30);
//        randomizedCollection.insert(30);
//
//        randomizedCollection.remove(10);
//        randomizedCollection.remove(10);
//        randomizedCollection.remove(30);
//        randomizedCollection.remove(30);
//
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
//        System.out.println(randomizedCollection.getRandom());
    }

    class RandomizedCollection {
        // 索引从0 开始
        // 索引 - 值
        Map<Integer, Integer> indexVals;
        // 值, 对应的索引
        Map<Integer, LinkedList<Integer>> valIndexs;
        Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            indexVals = new HashMap<>();
            valIndexs = new HashMap<>();
            random = new Random();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            int index = indexVals.size();
            indexVals.put(index, val);
            LinkedList<Integer> indexs = valIndexs.getOrDefault(val, new LinkedList<>());
            indexs.addLast(index);
            valIndexs.put(val, indexs);

            return indexs.size() <= 1;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!valIndexs.containsKey(val)) {
                return false;
            }

            LinkedList<Integer> indexs = valIndexs.get(val);
            Integer index = indexs.pollFirst();
            if (indexs.size() == 0) {
                valIndexs.remove(val);
            } else {
                valIndexs.put(val, indexs);
            }

            if (index != indexVals.size() - 1) {
                int lastVal = indexVals.get(indexVals.size() - 1);
                indexVals.put(index, lastVal);
                // 更新替换的值的valIndexs 的对应关系
                LinkedList<Integer> stack = valIndexs.get(lastVal);
                if (stack.size() != 0) {
                    stack.pollLast();
                    if (stack.size() == 0 || index > stack.peekLast()) {
                        stack.addLast(index);
                    } else {
                        stack.addFirst(index);
                    }

                    valIndexs.put(lastVal, stack);
                } else {
                    // 说明最后一个数就是当前需要删除的数
                }
                indexVals.remove(indexVals.size() - 1);
            } else {
                indexVals.remove(index);
            }


            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            if (indexVals.size() == 0) {
                return -1;
            }
            int index = random.nextInt(indexVals.size());
            return indexVals.get(index);
        }
    }
}
