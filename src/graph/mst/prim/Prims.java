package graph.mst.prim;

import java.util.Scanner;

public class Prims {

    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);

        System.out.println("Enter no. of vertices:");
        int n = in.nextInt();

        System.out.println("Enter no. of edges:");
        int e = in.nextInt();

        boolean[] visitedArray = initVisitedArray(n);
        //We have got the graph below:
        int[][] edges = initGraph(n, e);

        int[] parents = initParents(n);
        int[] weights = initWeights(n);

        createMST(visitedArray, edges, parents, weights);
    }

    private static void createMST(boolean[] visitedArray, int[][] edges, int[] parents, int[] weights) {
        int n = visitedArray.length;
        for(int i = 0; i < n; i++) {
            int currentVertex = i;
            int minVertex = -1;
            for(int j = 0; j < n; j++) {
                if (currentVertex == j) {
                    continue;
                }
                //Important condition..... here minVertex == -1 for first time check
                if (edges[currentVertex][j] != 0 && !visitedArray[j] && (minVertex == -1 || edges[currentVertex][j] < weights[minVertex])) {
                    //Important assignment...
                    minVertex = j;
                    parents[j] = currentVertex;
                    weights[j] = edges[currentVertex][j];
                    visitedArray[currentVertex] = true;
                    System.out.println(currentVertex+" "+j+" "+ weights[j]);
                }
            }
        }
    }

    private static boolean[] initVisitedArray(int noOfVertex) {
        boolean[] visitedArray = new boolean[noOfVertex];
        for (int i = 0; i < noOfVertex; i++) {
            visitedArray[i] = false;
        }
        return visitedArray;
    }

    private static int[][] initGraph(int noOfVertex, int noOfEdges) {
        int[][] edges = new int[noOfVertex][noOfVertex];
        for (int i = 0; i < noOfVertex; i++) {
            edges[i] = new int[noOfVertex];
            for (int j = 0; j < noOfVertex; j++) {
                edges[i][j] = 0;
            }
        }
        for (int i = 0; i < noOfEdges; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int weight = in.nextInt();
            edges[u][v] = weight;
            edges[v][u] = weight;
        }
        return edges;
    }

    private static int[] initWeights(int noOfVertex) {
        int[] weights = new int[noOfVertex];
        for (int i = 0; i < noOfVertex; i++) {
            if(i == 0) {
                weights[0] = i;
            } else {
                weights[i] = Integer.MAX_VALUE;
            }
        }
        return weights;
    }

    private static int[] initParents(int noOfVertex) {
        int[] parents = new int[noOfVertex];
        for (int i = 0; i < noOfVertex; i++) {
            parents[i] = -1;
        }
        return parents;
    }

}
