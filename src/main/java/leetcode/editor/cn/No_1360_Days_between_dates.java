package leetcode.editor.cn;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author gzm
 * @date 2020/10/15 3:50 下午
 * @desc: 1360. 日期之间隔几天
 * <p>
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 * <p>
 * 示例:
 * 输入：date1 = "2019-06-29", date2 = "2019-06-30"
 * 输出：1
 */
public class No_1360_Days_between_dates {
    @Test
    public void test() {
        String date1 = "2019-06-29", date2 = "2019-06-30";

        date1 = "2020-01-15";
        date2 = "2019-12-31";

        int daysBetweenDates = daysBetweenDates(date1, date2);
        System.out.println(daysBetweenDates);
    }

    public int daysBetweenDates(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate _date1 = LocalDate.parse(date1, formatter);
        LocalDate _date2 = LocalDate.parse(date2, formatter);

        long until = _date2.until(_date1, ChronoUnit.DAYS);
        return (int) Math.abs(until);
    }
}
