package day20260208;

import java.util.*;

public class Backjoon1068 {
    static int N;
    static List<Integer>[] tree;
    static int delNum;
    static boolean[] removed ;

    static int leafCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new ArrayList[N + 1];
       removed = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int parent = sc.nextInt();
            if(parent==-1)continue;
            tree[parent].add(i);
        }

        delNum = sc.nextInt();
        removeNode(delNum);
        dfsTree(1);
    }

    private static void removeNode(int delNum){
        removed[delNum] = true;
        for(int nextNode : tree[delNum]){
            if(removed[nextNode])continue;
            removeNode(nextNode);
        }
    }

    private static void dfsTree(int node){
        if(removed[node])return;
        boolean isLeaf = true;
        for(int child : tree[node]){
            if(!removed[node]){
                isLeaf = false;
                dfsTree(child);
            }
        }

        if(isLeaf) leafCount++;
    }


}
