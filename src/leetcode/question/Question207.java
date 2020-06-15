package leetcode.question;

import java.util.*;

/*
现在你总共有 n 门课需要选，记为 0 到 n-1。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
示例 1:
输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
* */
public class Question207 {
    class Node {
        int val;
        int arcCount;
        LinkedList<Integer> nextList;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> graph = new HashMap<>();
        //建图
        for (int i = 0; i < prerequisites.length; i++) {
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];    //pre
            Node n = null;
            if ((n = graph.get(y)) != null) {
                n.nextList.add(x);
            } else {
                Node node = new Node();
                node.val = y;
                node.nextList = new LinkedList<>();
                node.nextList.add(x);
                graph.put(y, node);
            }
            if (graph.get(x) != null) {
                graph.get(x).arcCount++;
            } else {
                Node node = new Node();
                node.val = x;
                node.arcCount = 1;
                node.nextList = new LinkedList<>();
                graph.put(x, node);
            }
        }
        //拓扑排序
        while (graph.size() > 0) {
            boolean f = false;
            Iterator<Integer> iterator = graph.keySet().iterator();
            while (iterator.hasNext()) {
                Node node = graph.get(iterator.next());
                if (node.arcCount == 0) {
                    f = true;
                    List<Integer> list = node.nextList;
                    for (int k : list) {
                        graph.get(k).arcCount--;
                    }
                    iterator.remove();
                }
            }
            if (!f) break;
        }
        return graph.size() == 0;
    }

    public static void main(String[] args) {
        Question207 q = new Question207();
        int[][] arr = {{0, 1}, {0, 2}, {1, 2}, {1, 0}};
        boolean b = q.canFinish(3, arr);
        System.out.println(b);
    }

}
