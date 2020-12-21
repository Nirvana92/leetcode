package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

/**
 * @author Nirvana
 * @date 2020/10/31 22:31
 * <p>
 * 218. 天际线问题
 */
public class No_218_Skyline_problem {
    @Test
    public void test() {
        int[][] buildings = new int[][]{
                {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
        };

//        buildings = new int[][]{
//                {2, 9, 10},
//                {4, 12, 8},
//                {5, 10, 8}
//        };

//        buildings = new int[][]{{0, 2, 3}, {2, 5, 3}};

        buildings = new int[][]{
                {0, 3, 3}, {1, 5, 3}, {2, 4, 3}, {3, 7, 3}
        };

        List<List<Integer>> skyline = getSkyline(buildings);
        System.out.println(skyline);
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int N = buildings.length;
        Info[] infos = new Info[2 * N];

        for (int i = 0; i < N; i++) {
            Info startInfo = new Info(buildings[i][0], buildings[i][2], true);
            Info endInfo = new Info(buildings[i][1], buildings[i][2], false);

            infos[i * 2] = startInfo;
            infos[i * 2 + 1] = endInfo;
        }

        Arrays.sort(infos, new MinCom());

        List<List<Integer>> rsts = new ArrayList<>();
        // 大根堆
        // PriorityQueue<Integer> queues = new PriorityQueue<>((Integer i1, Integer i2) -> i2 - i1);
        TreeMap<Integer, Integer> maps = new TreeMap<>();
        TreeMap<Integer, Integer> heightMaps = new TreeMap<>();

        for (int i = 0; i < infos.length; i++) {
            if (infos[i].isAdd) {
                maps.put(infos[i].height, maps.getOrDefault(infos[i].height, 0) + 1);
            } else {
                if (maps.getOrDefault(infos[i].height, 0) <= 1) {
                    maps.remove(infos[i].height);
                } else {
                    maps.put(infos[i].height, maps.getOrDefault(infos[i].height, 0) - 1);
                }
            }

            if (maps.isEmpty()) {
                heightMaps.put(infos[i].x, 0);
            } else {
                heightMaps.put(infos[i].x, maps.lastKey());
            }
        }

        int preHeight = 0;
        for (Map.Entry<Integer, Integer> entry : heightMaps.entrySet()) {
            Integer curKey = entry.getKey();
            Integer curMaxHeight = entry.getValue();
            if (preHeight != curMaxHeight) {

                rsts.add(new ArrayList<Integer>(Arrays.asList(curKey, curMaxHeight)));
                preHeight = curMaxHeight;
            }
        }

        return rsts;
    }

    @Test
    public void testComp() {
        Info startInfo = new Info(10, 5, true);
        Info endInfo = new Info(10, 15, false);
        Info[] infos = new Info[2];
        infos[0] = startInfo;
        infos[1] = endInfo;

        Arrays.sort(infos, new MinCom());
        for (int i = 0; i < infos.length; i++) {
            System.out.println(infos[i].x + "----" + infos[i].height);
        }
    }

    class MinCom implements Comparator<Info> {
        @Override
        public int compare(Info o1, Info o2) {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            }
            if (o1.isAdd != o2.isAdd) {
                return o1.isAdd ? -1 : 1;
            }

            return 0;
        }
    }

    class Info {
        int x;
        int height;
        boolean isAdd;

        public Info(int x, int height, boolean isAdd) {
            this.x = x;
            this.height = height;
            this.isAdd = isAdd;
        }
    }
}
