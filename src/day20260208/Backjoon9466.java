package day20260208;

import java.util.*;
import java.io.*;

public class Backjoon9466 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr;
    static boolean[] visited, finished;
    static int cnt;

    static void dfs(int x){
        int next = arr[x];
        visited[x] = true;

        if(!visited[next]){
            dfs(next);
        }else if (!finished[next]){
            for(int i = next; i!=x; i= arr[i]){
                cnt++;
            }
            cnt++;
        }
        finished[x] = true;
    }


    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(bf.readLine());

        for(int i=0;i<T;i++){
            N = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr = new int[N];
            visited = new boolean[N+1];
            finished = new boolean[N+1];
            cnt = 0;
            for(int idx=0;idx<N;idx++){
                arr[idx] = Integer.parseInt(st.nextToken());
            }

            for(int k=0;k<N;k++){
                if(!visited[k])dfs(k);

            }

            System.out.println(N-cnt);
        }
    }
}
