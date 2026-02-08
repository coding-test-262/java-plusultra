package day20260208;

import java.util.*;
import java.io.*;

public class Backjoon1987 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static char[][] map ;
    static int[] dy = {0,-1,0,1};
    static int[] dx = {1,0,-1,0};
    static int result =-1;
    static HashMap<Character, Boolean> myMap = new HashMap<>();

    private static boolean isInside(int sero,int garo){
        if(sero>=0&&sero<N && garo>=0&& garo<M)return true;
        return false;
    }

    private static void dfs(int sero,int garo, int count){

        result = Math.max(result,count);

        for(int i=0;i<4;i++){
            int ny = sero+dy[i];
            int nx = garo+dx[i];
            if(isInside(ny,nx)==false)continue;
            if(myMap.containsKey(map[ny][nx]))continue;
            myMap.put(map[ny][nx],true);
            dfs(ny,nx,count+1);
            myMap.remove(map[ny][nx]);
        }

    }

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0;i<N;i++){
            String str = bf.readLine();
            for(int k=0;k<M;k++){
                map[i][k] = str.charAt(k);
            }
        }

        myMap.put(map[0][0],true);
        dfs(0,0,1);
        System.out.println(result);
    }
}
