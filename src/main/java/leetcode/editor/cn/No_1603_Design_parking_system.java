package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/23 9:33 上午
 * @desc:1603. 设计停车系统
 */
public class No_1603_Design_parking_system {
    @Test
    public void test() {
        ParkingSystem system = new ParkingSystem(1, 1, 0);
        System.out.println(system.addCar(1));
        System.out.println(system.addCar(2));
        System.out.println(system.addCar(3));
        System.out.println(system.addCar(1));
    }

    class ParkingSystem {
        private int big;
        private int medium;
        private int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1) {
                // 大
                if (big > 0) {
                    big--;
                    return true;
                }
            } else if (carType == 2) {
                // 中
                if (medium > 0) {
                    medium--;
                    return true;
                }
            } else if (carType == 3) {
                // 小
                if (small > 0) {
                    small--;
                    return true;
                }
            }

            return false;
        }
    }
}
