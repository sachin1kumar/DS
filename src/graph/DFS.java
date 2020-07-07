package graph;

import java.util.Scanner;

public class DFS {

    private static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);

        System.out.println("Enter no. of vertices:");
        int n = in.nextInt();

        System.out.println("Enter no. of edges:");
        int e = in.nextInt();

        boolean[] visitedArray = initVisitedArray(n);
        int[][] edges = initGraph(n, e);

        printVertex(edges, 0, n, visitedArray);
    }

    private static boolean[] initVisitedArray(int noOfVertex){
        boolean[] visitedArray = new boolean[noOfVertex];
        for(int i = 0; i < noOfVertex; i++){
            visitedArray[i] = false;
        }
        return visitedArray;
    }

    private static int[][] initGraph(int noOfVertex, int noOfEdges){
        int[][] edges = new int[noOfVertex][noOfVertex];

        for(int i = 0; i < noOfVertex; i++){
            edges[i] = new int[noOfVertex];
            for(int j = 0; j < noOfVertex; j++){
                edges[i][j] = 0;
            }
        }

        for(int i = 0; i < noOfEdges; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            edges[u][v] = 1;
            edges[v][u] = 1;
        }

        return edges;
    }

    private static void printVertex(int[][] edges, int sv, int noOfVertex, boolean[] visitedArray){
        System.out.print(sv+" ");
        visitedArray[sv] = true;
        for (int i = 0; i < noOfVertex; i++){
            if(sv == i){
                continue;
            }
            if(edges[sv][i] == 1){
                if(visitedArray[i]){
                    continue;
                }
                printVertex(edges, i, noOfVertex, visitedArray);
            }
        }
    }

}
