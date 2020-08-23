package graph.dijkstra;

import java.util.Scanner;

public class Dijkstra {

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
        int[] distanceArray = initDistanceArray(n);
        applyAlgo(visitedArray, edges, distanceArray);
    }

    private static void applyAlgo(boolean[] visitedArray, int[][] edges, int[] distanceArray) {
        int n = visitedArray.length;

        for (int i = 0; i < n; i++) {
            //find vertex having min. distance..
            int minVertex = findMinVertex(distanceArray, visitedArray, n);
            //mark it visited..
            visitedArray[minVertex] =  true;
            for(int j = 0; j < n; j++) {
                if(j == minVertex) {
                    continue;
                }
                if (edges[minVertex][j] != 0 && !visitedArray[j]) {
                    //calculate distance from min vertex to current vertex..
                    int dist = distanceArray[minVertex] + edges[minVertex][j];
                    if(dist < distanceArray[j]) {
                        distanceArray[j] = dist;
                    }
                }
            }
        }

        //print output.... current vertex and it's cost/distance
        for (int i = 0; i < n; i++) {
            System.out.println(i+" "+distanceArray[i]);
        }
    }

    private static int findMinVertex(int[] distanceArray, boolean[] visitedArray, int n) {
        int minVertex = -1;
        for (int i = 0; i < n; i++) {
            //Very important check....
            if(!visitedArray[i] && (minVertex == -1 || distanceArray[i] < distanceArray[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    private static int[] initDistanceArray(int n) {
        int[] distanceArray = new int[n];
        for (int i = 0; i < n; i++) {
            distanceArray[i] = Integer.MAX_VALUE;
        }
        distanceArray[0] = 0;
        return distanceArray;
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

}
