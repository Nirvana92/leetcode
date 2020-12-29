package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzm
 * @date 2020/12/24 8:39 下午
 * @desc: 1206. 设计跳表
 * <p>
 * 跳表的实现
 * <p>
 * 跳表相关介绍: https://en.wikipedia.org/wiki/Skip_list
 */
public class No_1206_Design_jump_table {
    @Test
    public void test() {
        Skiplist skiplist = new Skiplist();

        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        // 返回 false
        System.out.println(skiplist.search(0));
        skiplist.add(4);
        // 返回 true
        System.out.println(skiplist.search(1));
        // 返回 false，0 不在跳表中
        System.out.println(skiplist.erase(0));
        // 返回 true
        System.out.println(skiplist.erase(1));
        // 返回 false，1 已被擦除
        System.out.println(skiplist.search(1));
    }

    @Test
    public void testSkipList() {
        Skiplist skiplist = new Skiplist();

        skiplist.add(1);
        skiplist.search(2);
        skiplist.add(2);
        skiplist.erase(2);

//        skiplist.add(9);
//        skiplist.add(4);
//        skiplist.add(5);
//        skiplist.add(6);
//        skiplist.add(9);
//
//        skiplist.erase(2);
//        skiplist.erase(1);
//
//        skiplist.add(2);
//
//        System.out.println(skiplist.search(7));
//        System.out.println(skiplist.search(4));
//
//        skiplist.add(5);
//        skiplist.erase(6);
//        System.out.println(skiplist.search(5));
//
//        skiplist.add(6);
//        skiplist.add(7);
//        skiplist.add(4);
//
//        skiplist.erase(3);
//        System.out.println(skiplist.search(6));
//        skiplist.erase(3);
//        System.out.println(skiplist.search(4));
    }

    @Test
    public void parseParamsAndTest() {
        String operations = "add,add,add,add,add,add,add,add,add,erase,search,add,erase,erase,erase,add,search,search,search,erase,search,add,add,add,erase,search,add,search,erase,search,search,erase,erase,add,erase,search,erase,erase,search,add,add,erase,erase,erase,add,erase,add,erase,erase,add,add,add,search,search,add,erase,search,add,add,search,add,search,erase,erase,search,search,erase,\n" +
                "search,add,erase,search,erase,search,\n" +
                "erase,erase,search,search,add,add,add,add,search,search,search,search,search,search,search,search,search";
        String params = "16,5,14,13,0,3,12,9,12,3,6,7,0,1,10,5,12,7,16,7,0,9,16,3,2,17,2,17,0,9,14,1,6,1,16,9,10,9,2,3,16,15,12,7,4,3,2,1,14,13,12,3,6,17,2,3,14,11,0,13,2,1,10,17,0,5,8,9,8,11,10,11,10,9,8,15,14,1,6,17,16,13,4,5,4,17,16,7,14,1";

        String[] opers = operations.split(",");
        String[] param = params.split(",");

        Skiplist skiplist = new Skiplist();

        for (int i = 0; i < opers.length; i++) {
            String curOper = opers[i];
            int curParam = Integer.parseInt(param[i]);

            if (curParam == 9) {
                System.out.println("---" + curOper + ", " + curParam);
            }

            if (curOper.equals("add")) {
                skiplist.add(curParam);
                // System.out.print("null,");
            } else if (curOper.equals("erase")) {
                boolean ret = skiplist.erase(curParam);
                // System.out.print(ret + ",");
            } else if (curOper.equals("search")) {
                boolean ret = skiplist.search(curParam);
                // System.out.print(ret + ",");
            }
        }
    }

    class Skiplist {
        // 用于判断层数的中间值
        private final double MIDDLE_BOUNDARY = 0.5D;
        // 当前Node的key 值
        private Integer key;
        // 当前跳表的最大层数
        private int maxLevel = 0;
        // 当前层的每层的node节点集合
        private List<Skiplist> nextNodes;

        public Skiplist() {
            // 头结点的key值为空, 标识系统最小
            key = null;
            nextNodes = new ArrayList<>();
            // 第0 层的next 节点为空
            nextNodes.add(null);
        }

        /**
         * 判断target 是否存在
         *
         * @param target
         * @return
         */
        public boolean search(int target) {
            // 跳表没初始化的时候, 找到的节点为空
            Skiplist curNode = getMostRightNodeInSkipList(target);

            if (curNode != null) {
                Skiplist nextNode = curNode.nextNodes.get(0);
                return nextNode != null && nextNode.key == target;
            }
            return false;
        }

        /**
         * 在跳表中找到小于 target 的最左节点
         *
         * @param target
         * @return
         */
        Skiplist getMostRightNodeInSkipList(int target) {
            // 从最大层数往下找
            int curLevel = maxLevel;

            Skiplist curNode = this;
            while (curNode != null && curLevel >= 0) {
                curNode = getMostRightNodeInLevel(curNode, target, curLevel--);
            }

            return curNode;
        }

        /**
         * 在level 层找到小于target 的最左节点
         *
         * @param curNode
         * @param target
         * @param level
         * @return
         */
        Skiplist getMostRightNodeInLevel(Skiplist curNode, int target, int level) {
            Skiplist nextNode = curNode.nextNodes.get(level);
            while (nextNode != null && nextNode.key < target) {
                curNode = nextNode;
                nextNode = curNode.nextNodes.get(level);
            }

            return curNode;
        }

        /**
         * 添加元素到跳表中
         *
         * @param num 按照测试样例的方法应该是相同的num 也需要添加上去
         */
        public void add(int num) {
            // 首先判断是否存在 num, 然后通过随机数看num 能生成几层
            if (search(num)) {
                // 存在num, 直接返回, 如果是K-V 键值的方式, 可以执行更新V 的操作
                return;
            } else {
                int curNumLevel = 0;

                // 等待添加到跳表中的节点
                Skiplist curNode = new Skiplist();
                curNode.key = num;

                // 如果随机数为 [0, 0.5): 新增一层, 随机数为[0.5, 1) 停止随机操作
                while (Math.random() < MIDDLE_BOUNDARY) {
                    curNumLevel++;
                    curNode.nextNodes.add(null);
                }
                curNode.maxLevel = curNumLevel;

                // 判断该节点的层数是否超过之前的层数. 初始化超过maxLevel 的头结点数据
                while (curNumLevel > maxLevel) {
                    nextNodes.add(null);
                    maxLevel++;
                }

                // 依次填充每层的数据
                // 需要从最高层开始寻找, 然后依次新增
                int level = maxLevel;
                while (level >= 0) {
                    Skiplist mostRightNodeInLevel = getMostRightNodeInLevel(this, num, level);
                    Skiplist nextNode = mostRightNodeInLevel.nextNodes.get(level);

                    if (level <= curNumLevel) {
                        mostRightNodeInLevel.nextNodes.set(level, curNode);
                        curNode.nextNodes.set(level, nextNode);
                    }
                    level--;
                }
            }
        }

        /**
         * 删除num
         *
         * @param num
         * @return
         */
        public boolean erase(int num) {
            if (!search(num)) {
                return false;
            }

            // 需要遍历每层的小于 num 的最左的节点, 然后依次删除 num 的值的节点
            int curMaxLevel = maxLevel;

            // 遍历每层的小于 num 的最左节点, 然后依次进行删除操作
            Skiplist curNode = this;
            while (curMaxLevel >= 0) {
                Skiplist mostRightNodeInLevel = getMostRightNodeInLevel(curNode, num, curMaxLevel);
                Skiplist targetNumNode = mostRightNodeInLevel.nextNodes.get(curMaxLevel);

                // 当前待删除的节点有可能层数比别的节点多出很多层, 所以需要坐下判断
                if (targetNumNode != null && targetNumNode.key == num) {
                    mostRightNodeInLevel.nextNodes.set(curMaxLevel, targetNumNode.nextNodes.get(curMaxLevel));
                    targetNumNode.nextNodes.remove(curMaxLevel);
                }

                // 如果当前节点的层数是唯一一个高的节点, 删除当前节点之后 maxLevel 需要递减。
                // 当前层不是第0 层, 最左节点等于头结点, 下一个节点为空则可以进行层次的递减。
                if (curMaxLevel != 0 && mostRightNodeInLevel == this && mostRightNodeInLevel.nextNodes.get(curMaxLevel) == null) {
                    nextNodes.remove(curMaxLevel);
                    maxLevel--;
                }

                curMaxLevel--;
            }

            return true;
        }
    }
}
