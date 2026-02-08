package day20260208;

import java.util.*;
import java.io.*;

public class Backjoon19598 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static ArrayList<Node> times = new ArrayList<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            times.add(new Node(start,end));
        }

        times.sort((a,b)->{
            return a.start-b.start;
        });

        for(int i=0;i<times.size();i++){

            if(!pq.isEmpty()&& pq.peek()<= times.get(i).start){
                pq.poll();
            }

            pq.add(times.get(i).end);
        }

        System.out.println(pq.size());
    }

    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
