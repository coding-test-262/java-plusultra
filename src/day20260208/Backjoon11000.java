package day20260208;

import java.util.*;
import java.io.*;

public class Backjoon11000 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static ArrayList<Node> arrs = new ArrayList<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arrs.add(new Node(start, end));
        }

        arrs.sort((a, b) -> {
            return a.start - b.start;
        });

        int max = 0;
        for (int i = 0; i < arrs.size(); i++) {

            while(!pq.isEmpty()&& pq.peek()<= arrs.get(i).start){
                pq.poll();
            }

            pq.add(arrs.get(i).end);
            max = Math.max(pq.size(),max);
        }

        System.out.println(max);
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
