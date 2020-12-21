package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

/**
 * @author gzm
 * @date 2020/9/22 5:14 下午
 * @desc
 */
public class No_207_class_schedule {

    @Test
    public void test() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        boolean canFinish = canFinish(numCourses, prerequisites);
        System.out.println(canFinish);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Info> clazzMaps = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int to = prerequisite[0];
            int from = prerequisite[1];

            if (!clazzMaps.containsKey(to)) {
                clazzMaps.put(to, new Info(to));
            }

            if (!clazzMaps.containsKey(from)) {
                clazzMaps.put(from, new Info(from));
            }

            // 到达的点入度 +1
            clazzMaps.get(to).incrIn();
            clazzMaps.get(from).addNext(clazzMaps.get(to));
        }

        // 初始化好了课程依赖表, 遍历集合中的数据, 从入度为 0 的开始一次减少依赖

        int clazzNums = clazzMaps.size();
        Queue<Info> queue = new LinkedList<>();
        for (Info info : clazzMaps.values()) {
            if (info.in == 0) {
                queue.add(info);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Info curInfo = queue.poll();
            count++;
            for (Info info : curInfo.next) {
                if (--info.in == 0) {
                    queue.add(info);
                }
            }
        }

        return count == clazzNums;
    }

    class Info {
        int clazz;
        int in;
        List<Info> next;

        public Info(int clazz) {
            this.clazz = clazz;
            next = new ArrayList<>();
        }

        public void addNext(Info info) {
            next.add(info);
        }

        public void incrIn() {
            in++;
        }
    }
}
