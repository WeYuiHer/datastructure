package graph;

public class MGraph {
    int n, e;        //图中的顶点和边数
    int[][] edges;

    public MGraph() {
		/*edges = new int[100][100];
		n = 100;
		e = 0;*/
    }

    public MGraph(int n) {
        this.n = n;
        e = 0;
        edges = new int[n][n];
    }

    public void create(int[][] A) {
        int n = A.length;
        this.n = n;
        this.e = 0;
        edges = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edges[i][j] = A[i][j];
                if (A[i][j] != 0)
                    e++;
            }
        }
    }


}
