package day20260208;

import java.util.*;
import java.io.*;

public class Backjoon2109 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        return -1*(a-b);
    });

    static ArrayList<Node> arrs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bf.readLine());
        int maxDay = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int value ,day;
            value = Integer.parseInt(st.nextToken());
            day = Integer.parseInt(st.nextToken());

            arrs.add(new Node(value,day));
            maxDay = Math.max(maxDay,day);

        }

        arrs.sort((a,b)->{
            return -1*(a.day-b.day);
        });


        int idx = 0 ,answer=0;
        for(int day = maxDay; day>=1;day--){

            while(idx<N && arrs.get(idx).day>=day){
                pq.add(arrs.get(idx).value);
                idx++;
            }

            if(!pq.isEmpty()){
                answer+=pq.poll();
            }
        }

        System.out.println(answer);
    }

    static class Node {
        int value;
        int day;

        public Node(int value, int day) {
            this.value = value;
            this.day = day;
        }


    }
}
