package day20260205;

import java.util.*;
import java.io.*;

public class Backjoon2470 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Integer[] arr ;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bf.readLine());
        arr = new Integer[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a,b)->{
            return a-b;
        });

        int left = 0;
        int right = N-1;
        int maxNum = 2000000001;

        int resultLeftNum= -1;
        int resultRightNum = -1;

        while(left<right){
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < maxNum){
                maxNum = Math.abs(sum);
                resultLeftNum = arr[left];
                resultRightNum = arr[right];
            }

            if(sum<0){
                left++;
            }
            else{
                right--;
            }
        }

        System.out.print(resultLeftNum);
        System.out.print(' ');
        System.out.print(resultRightNum);
    }
}
