package day2026129;

import java.io.*;
import java.util.*;

public class Backjoon1149 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;
    static int[][] dp;

    static void init() throws Exception {
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][3];
        dp = new int[N][3];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int k=0;k<3;k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        for(int i=0;i<3;i++){
            dp[0][i] = arr[0][i];
        }

        for(int i=1;i<N;i++){
            dp[i][0] = arr[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][1],dp[i-1][0]);
        }

        int minNum = 987654321;

        for(int i=0;i<3;i++){
            minNum = Math.min(minNum,dp[N-1][i]);
        }

        System.out.println(minNum);
    }
}
