package day2026129;

import java.util.*;
import java.io.*;

public class Backjoon2473 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Integer[] arr;


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new Integer[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(a,b)->{
            return a-b;
        });

        long answer = 3000000001L;
        Long[] answers = new Long[3];
        for(int i=0;i<N-2;i++){
            int left = i+1;
            int right = N-1;
            int selectedNum = arr[i];
            while(left<right){
                int mid = (left+right)/2;
                long target = (long)(arr[left]+arr[right]+ selectedNum);
                if(target<0){
                    if(Math.abs(target)<answer){
                        answer = Math.abs(target);
                        answers[0] = (long)selectedNum;
                        answers[1] = (long)arr[left];
                        answers[2] = (long)arr[right];
                    }
                    left++;
                }
                else{
                    right--;
                }
            }
        }

        Arrays.sort(answers,(a,b)->{
            return Long.compare(a,b);
        });

        System.out.print(answers[0]);
        System.out.print(' ');
        System.out.print(answers[1]);
        System.out.print(' ');
        System.out.print(answers[2]);


    }
}
