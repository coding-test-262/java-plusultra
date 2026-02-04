package day2026129;

import java.util.*;
import java.io.*;

public class Backjoon1325 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static ArrayList<Integer>[] arrs;

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrs = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            arrs[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int start, end ;
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            arrs[end].add(start);
        }
    }

    static Node BFS(int start){
        int count = 0;
        Queue<Integer> myQueue =new ArrayDeque<>();
        myQueue.add(start);

        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        while(!myQueue.isEmpty()){
            int nowPoint = myQueue.peek();
            myQueue.poll();
            count++;

            for(int nextPoint : arrs[nowPoint]){
                if(visited[nextPoint])continue;
                myQueue.add(nextPoint);
                visited[nextPoint] = true;
            }
        }

        return new Node(count, start);
    }

    public static void main(String[]args) throws Exception{
        input();
        int maxNum = -1;
        ArrayList<Node> computers = new ArrayList<>();

        for(int i=1;i<=N;i++){
            computers.add(BFS(i));
        }

        computers.sort((a,b)->{
            return -1*(a.count - b.count);
        });

        int nowPoint = computers.get(0).count;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<computers.size();i++){
            if(nowPoint== computers.get(i).count){
                sb.append(computers.get(i).computerNum).append(' ');
            }
            else{
                break;
            }
        }

        System.out.println(sb);
    }

    static class Node{
        int count;
        int computerNum;

        public Node(int a, int b) {
            count = a;
            computerNum = b;
        }
    }
}
