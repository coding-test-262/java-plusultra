package day20260208;

import java.util.*;
import java.io.*;

public class Backjoon1202 {
    static int N,K;
    static List<Node> arrs = new ArrayList<>();
    static int[] bags;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bags = new int[K];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arrs.add(new Node(m,v));
        }

        for(int i=0;i<K;i++){
            int v = Integer.parseInt(bf.readLine());
            bags[i] = v;
        }

        Arrays.sort(bags);
        arrs.sort((a,b)->{
            return a.m-b.m;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        int idx = 0;
        long answer = 0;
        for(int i=0;i<bags.length;i++){

            int bagM = bags[i];

            while(idx<N&& arrs.get(idx).m <=bagM){
                pq.add(arrs.get(idx).v);
                idx++;
            }

            if(!pq.isEmpty())answer+= pq.poll();
        }

        System.out.println(answer);
    }

    static class Node{
        int m;
        int v;

        public Node(int m, int v){
            this.m = m;
            this.v = v;
        }
    }
}
