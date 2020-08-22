package graph.mst.kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int e = scanner.nextInt();
        int v = scanner.nextInt();
        Edge[] edges = createEdges(e);
        ArrayList<Edge> output = createOutputMST(edges, v);

        //print output
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i).getS()+" "+output.get(i).getD()+" "+output.get(i).getW());
        }
    }

    private static Edge[] createEdges(int e) {
        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            Edge edge = new Edge(s, d, w);
            edges[i] = edge;
        }
        //sort the edges in ascending order to apply greedy approach..
        sortEdges(edges);
        return edges;
    }

    private static void sortEdges(Edge[] edges) {
        Arrays.sort(edges);
    }

    private static int[] createParentArray(int v) {
        int[] parents = new int[v];
        for (int i = 0; i < v; i++) {
            parents[i] = i;
        }
        return parents;
    }

    private static boolean isCyclePresent(Edge edge, int[] parentArray) {
        int sourceParent = parentArray[edge.getS()];
        int destParent = parentArray[edge.getD()];
        if(sourceParent == destParent) {
            return true;
        } else {
            parentArray[edge.getD()] = sourceParent;
        }
        return false;
    }

    private static ArrayList<Edge> createOutputMST(Edge[] edges, int v) {
        int[] parents = createParentArray(v);
        ArrayList<Edge> output = new ArrayList<>();

        int i = 0;
        int n = edges.length;

        while (i < n) {
            if(!isCyclePresent(edges[i], parents)) {
                output.add(edges[i]);
            }
            i++;
        }
        return output;
    }


}


