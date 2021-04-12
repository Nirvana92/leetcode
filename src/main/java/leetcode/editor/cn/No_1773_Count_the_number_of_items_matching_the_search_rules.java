package leetcode.editor.cn;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzm
 * @date 2021/3/3 9:31 上午
 * @desc: 1773. 统计匹配检索规则的物品数量
 */
public class No_1773_Count_the_number_of_items_matching_the_search_rules {
    @Test
    public void test() {
        // String[] strs = new String[2];

        List<String> item1 = Lists.newArrayList("phone", "blue", "pixel");
        List<String> item2 = Lists.newArrayList("computer", "silver", "lenovo");
        List<List<String>> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        String ruleKey = "color", ruleValue = "silver";


        int countMatches = countMatches(items, ruleKey, ruleValue);
        System.out.println(countMatches);
    }

    /**
     * 根据ruleKey 的值确定需要判断的值得内容, 然后遍历items 去匹配. 返回匹配到的结果
     *
     * @param items
     * @param ruleKey
     * @param ruleValue
     * @return
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int result = 0;

        for (List<String> item : items) {
            if ("type".equals(ruleKey)) {
                // 类型
                if (ruleValue.equals(item.get(0))) {
                    result++;
                }
            } else if ("color".equals(ruleKey)) {
                // 颜色
                if (ruleValue.equals(item.get(1))) {
                    result++;
                }
            } else {
                // name: 名称
                if (ruleValue.equals(item.get(2))) {
                    result++;
                }
            }
        }

        return result;
    }
}
