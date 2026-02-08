package day2026129;

import java.io.*;

public class Backjoon1300 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bf.readLine());
        K = Integer.parseInt(bf.readLine());

        int left = 1;
        int right = K;
        int answer= -1;
        while(left<=right){
            int mid = (left+right)/2;
            int count = 0;

            for(int i=1;i<=N;i++){
                count +=Math.min(mid/i, N);
            }

            if(count>=K){
                answer = mid;
                right = mid-1;
            }
            else{
                left=mid+1;
            }

        }

        System.out.println(answer);


    }
}
