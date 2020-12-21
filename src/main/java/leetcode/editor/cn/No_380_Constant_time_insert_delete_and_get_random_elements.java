package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Nirvana
 * @date 2020/10/24 16:31
 * <p>
 * 380. 常数时间插入、删除和获取随机元素
 * <p>
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * <p>
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 */
public class No_380_Constant_time_insert_delete_and_get_random_elements {
    @Test
    public void test() {
        RandomizedSet randomizedSet = new RandomizedSet();
//        randomizedSet.insert(0);
//        randomizedSet.insert(1);
//        randomizedSet.remove(0);
//
//        randomizedSet.insert(2);
//
//        randomizedSet.remove(1);
//        int random = randomizedSet.getRandom();
//        System.out.println(random);

        randomizedSet.insert(0);
        randomizedSet.insert(2);
        randomizedSet.insert(1);
        randomizedSet.insert(1);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        //randomizedSet.print();
        System.out.println(randomizedSet.insert(0));

    }

    class RandomizedSet {
        // 索引 -> val
        Map<Integer, Integer> datas;
        // val -> 索引
        Map<Integer, Integer> indexs;
        Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            datas = new HashMap<>();
            indexs = new HashMap<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (indexs.containsKey(val)) {
                return false;
            }

            int index = datas.size();
            datas.put(index, val);
            indexs.put(val, index);

            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!indexs.containsKey(val)) {
                return false;
            }

            Integer index = indexs.get(val);
            indexs.remove(val);
            if (index == datas.size() - 1) {
                datas.remove(index);
            } else {
                // 用index 最后的位置填充需要删除的位置的值
                int updateVal = datas.get(datas.size() - 1);
                datas.put(index, updateVal);
                indexs.put(updateVal, index);
                datas.remove(datas.size() - 1);
            }

            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return datas.get(random.nextInt(datas.size()));
        }

//        void print() {
//            System.out.println("datas: " + datas);
//            System.out.println("indexs: " + indexs);
//            System.out.println("=====================");
//        }
    }
}
