package graph;

import stack.Stack;

import java.util.Scanner;
//With Stack data structure.
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
            edges[u][v] = 1;
            edges[v][u] = 1;
        }

        return edges;
    }

    private static void printVertex(int[][] edges, int sv, int noOfVertex, boolean[] visitedArray){
        Stack stack = new Stack();
        stack.pushElement(sv);
        visitedArray[sv] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.topElement();
            System.out.print(currentVertex+" ");
            stack.popElement();

            for(int i = 0; i < noOfVertex; i++) {
                if(currentVertex == i) {
                    continue;
                }
                if (edges[currentVertex][i] == 1 && !visitedArray[i]) {
                    stack.pushElement(i);
                    visitedArray[i] = true;
                }
            }
        }
    }

}
