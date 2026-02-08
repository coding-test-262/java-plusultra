package day20260208;

import java.util.*;
import java.io.*;

public class Backjoon1167 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Node>[] tree;

    static int N;
    static int leafNodeNum;
    static int result = 0;
    static boolean[] visited ;

    private static void dfs(int num,int dist){
        if(result < dist){
            result = dist;
            leafNodeNum = num;
        }

        for(Node childNode : tree[num]){
            int next = childNode.num;
            int value = childNode.value;
            if(visited[next])continue;
            visited[next] = true;
            dfs(next, dist+value);
        }
    }

    public static void main(String[] args)throws Exception {
        N = Integer.parseInt(bf.readLine());
        tree = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<=N;i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int node = Integer.parseInt(st.nextToken());
            while(true) {
                int nextNode = Integer.parseInt(st.nextToken());
                if(nextNode==-1)break;
                int value = Integer.parseInt(st.nextToken());

                tree[node].add(new Node(nextNode,value));
                tree[nextNode].add(new Node(node,value));
            }
        }

        visited[1] = true;
        dfs(1,0);
        for(int i=0;i<=N;i++){
            visited[i] = false;
        }
        result = 0;
        visited[leafNodeNum] = true;
        dfs(leafNodeNum,0);

        System.out.println(result);
    }

    static class Node {
        int num;
        int value;

        public Node(int num,int value){
            this.num = num;
            this.value = value;
        }
    }
}
