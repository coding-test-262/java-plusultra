package day20260208;

import java.util.*;

public class Backjoon1119 {
    static int N;
    static boolean[][] graph;
    static boolean[] visited;

    static void dfs(int node){
        visited[node] = true;
        for(int i=0;i<N;i++){
            if(graph[node][i] && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new boolean[N][N];
        visited = new boolean[N];

        for(int i=0;i<N;i++){
            String line = sc.next();
            for(int j=0;j<N;j++){
                graph[i][j] = (line.charAt(j)=='Y');
            }
        }

        int components= 0;
        for(int i=0;i<N;i++){
            if(!visited[i]){
                dfs(i);
                components++;
            }
        }

        System.out.println(components == 1?0 : components -1);
    }
}
