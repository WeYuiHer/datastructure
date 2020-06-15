package leetcode.question;

import java.util.*;

/*
* 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:
如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:
输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
输出: 5
解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
* */
public class Question127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Boolean> visit = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String str = wordList.get(i);
            visit.put(str, false);
            List<String> list = map.get(str);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(str, list);
        }
        bfs(visit, map, beginWord, endWord);

        return cnt;
    }

    int cnt = 0;

    public void bfs(Map<String, Boolean> visit, Map<String, List<String>> map, String beginWord, String endWord) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int x = queue.size();
            for (int i = 0; i < x; i++) {
                String str = queue.poll();
                if (str.equals(endWord))
                    return;
                List<String> list = map.get(str);
                visit.put(str, true);
                if (list != null) {
                    for (String s : list) {
                        if (!visit.get(s))
                            queue.offer(s);

                    }
                }
            }
            cnt++;
        }
    }


    //两个单词是否相差一个字母
    public boolean wordSimilar(String w1, String w2) {
        int n = w1.length();
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                x++;
                if (x > 1)
                    return false;
            }
        }
        return true;
    }


}









