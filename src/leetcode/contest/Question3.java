package leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
* 给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，
* 推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
* */
public class Question3 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String sub = searchWord.substring(0, i + 1);
            ArrayList<String> l = new ArrayList<>();
            for (int j = 0; j < products.length; j++) {
                if (products[j].startsWith(sub) && l.size() < 3)
                    l.add(products[j]);
            }
            list.add(l);
        }
        return list;
    }
}
