package graph.mst.kruskal;

public class Edge implements Comparable<Edge> {

    private int s;
    private int d;
    private int w;

    public Edge(int s, int d, int w) {
        this.s = s;
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return (int) (this.w - o.w);
    }


    public int getS() {
        return s;
    }

    public int getD() {
        return d;
    }

    public int getW() {
        return w;
    }
}
