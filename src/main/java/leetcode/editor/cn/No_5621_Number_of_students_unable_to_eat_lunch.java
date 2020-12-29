package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/28 9:15 上午
 * @desc: 5621. 无法吃午餐的学生数量
 * <p>
 * 模拟就好了, 以sandwiches 做标准然后依次消费students来处理
 */
public class No_5621_Number_of_students_unable_to_eat_lunch {
    @Test
    public void test() {
        int[] students = new int[]{1, 1, 0, 0};
        int[] sandwiches = new int[]{0, 1, 0, 1};

//        students = new int[]{1, 1, 1, 0, 0, 1};
//        sandwiches = new int[]{1, 0, 0, 0, 1, 1};

        int countStudents = countStudents(students, sandwiches);
        System.out.println(countStudents);
    }

    /**
     * 如果students 分配到了三明治, 将数组中的值设置为 -1
     * 循环sandwiches, 然后依次在 students 数组中找到匹配的位置直到遍历一遍都没有找到合适的位置, 则直接返回
     *
     * @param students
     * @param sandwiches
     * @return
     */
    public int countStudents(int[] students, int[] sandwiches) {
        // 拿到三明治的同学的数量
        int counts = 0;

        int studentIndex = 0, preStudentIndex = -1;
        for (int i = 0; i < sandwiches.length; i++) {
//            if (studentIndex == preStudentIndex) {
//                // 循环了一个轮回直接返回结果
//                return -1;
//            }

            boolean getSandwiche = false;
            for (int j = 0; j < students.length; j++) {
                int curIndex = studentIndex % students.length;

                if (students[curIndex] != -1 && students[curIndex] == sandwiches[i]) {
                    students[curIndex] = -1;
                    counts++;
                    getSandwiche = true;
                }
                studentIndex++;

                if (getSandwiche) {
                    break;
                }
            }

            if (!getSandwiche) {
                return students.length - counts;
            }
        }

        return students.length - counts;
    }
}
