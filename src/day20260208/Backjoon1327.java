package day20260208;

import java.util.*;

public class Backjoon1327 {
    static int N,K;
    static Scanner sc = new Scanner(System.in);
    static int[] arr;
    public static void main(String[] args) {
        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        Queue<int[]> q = new ArrayDeque<>();
        Queue<Integer> cntQ = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.add(arr);
        cntQ.add(0);
        visited.add(arrToString(arr));

        int[] target = new int[N];
        for(int i=0;i<N;i++)target[i] =i+1;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cnt = cntQ.poll();

            if(Arrays.equals(now,target)){
                System.out.println(cnt);
                return;
            }

            for(int i=0;i<=N-K;i++){
                int[] next = now.clone();

                for(int l=0; l <K/2;l++){
                    int tmp = next[i + l];
                    next[i + l] = next[i + K - 1 - l];
                    next[i + K - 1 - l] = tmp;
                }
                String key = arrToString(next);
                if(!visited.contains(key)){
                    visited.add(key);
                    q.add(next);
                    cntQ.add(cnt+1);
                }
            }
        }
        System.out.println(-1);
    }

    private static String arrToString(int[] next) {
        StringBuilder sb = new StringBuilder();
        for (int n : next) sb.append(n).append(",");
        return sb.toString();
    }
}
