package graph;

import java.util.HashMap;
import java.util.Scanner;

public class ColourGraph {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //no. of vertices.
        int m = in.nextInt(); //no. of edges.

        for(int i = 1; i <= n; i++){
            if(i % 2 != 0){
                map.put(i, "Red");
            } else {
                map.put(i, "Blue");
            }
        }

        int[][] edges = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            edges[i] = new int[n+1];
            for(int j = 1; j <= n; j++){
                edges[i][j] = 0;
            }
        }

        for(int i = 1; i <= m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            edges[u][v] = 1;
            edges[v][u] = 1;
        }

        boolean isColourable = true;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(edges[i][j] == 1){
                    if(map.get(i).equalsIgnoreCase(map.get(j))){
                        isColourable = false;
                    }
                }
            }
        }

        if(isColourable){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
