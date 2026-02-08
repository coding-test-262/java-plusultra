package day20260208;

import java.util.*;

public class Backjoon11003 {
    static int N, L;
    static int[] arr;
    static PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
        return a.value-b.value;
    });
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        N = sc.nextInt();
        L = sc.nextInt();
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            if(pq.size()<=L){
                pq.add(new Node(arr[i],i));
            }
            else{
                pq.add(new Node(arr[i],i));
                while(!pq.isEmpty()){
                    int idx = pq.peek().idx;
                    if(idx<i-L+1)pq.poll();
                    else break;
                }
            }
            sb.append(pq.peek().value).append(' ');
        }
        System.out.println(sb);
    }

    static class Node {
        int value;
        int idx;

        public Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
}
