package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ArcNode {

    int adjvex;
    ArcNode next;

    public ArcNode() {
    }

    public ArcNode(int adjvex, ArcNode next) {
        this.adjvex = adjvex;
        this.next = next;
    }
}

public class AGraph {
    List<ArcNode>[] adjlist;  //临接表
    int n, e;                //顶点、边数

    public void create(int[][] A) {
        int n = A.length;
        adjlist = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adjlist[i] = new ArrayList<ArcNode>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    ArcNode node = new ArcNode(j, adjlist[i].isEmpty() ? null : adjlist[i].get(0));
                    adjlist[i].add(node);
                    e++;
                }
            }
        }
    }

    //深度优先遍历
    public void dfs(boolean[] visit, int cur) {
        System.out.print(cur + " ");
        visit[cur] = true;
        for (ArcNode node : adjlist[cur]) {
            if (!visit[node.adjvex]) {
                dfs(visit, node.adjvex);
            }
        }
    }

    //广度优先遍历
    public void bfs(boolean[] visit, int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visit[cur] = true;
        int x;
        while (!queue.isEmpty()) {
            x = queue.poll();
            System.out.print(x + "  ");
            for (ArcNode node : adjlist[x]) {
                if (!visit[node.adjvex]) {
                    visit[node.adjvex] = true;
                    queue.offer(node.adjvex);
                }
            }
        }
    }


    public static void main(String[] args) {
        AGraph graph = new AGraph();
        int[][] A = {
                {0, 1, 0, 1, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        graph.create(A);
        boolean[] visit = new boolean[5];
        graph.dfs(visit, 1);

        //graph.bfs(visit, 1);
    }

}





