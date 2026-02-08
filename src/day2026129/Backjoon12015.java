package day2026129;

import java.util.*;
import java.io.*;

public class Backjoon12015 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] arr;

    public static void main(String[]args) throws Exception{
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for(int i=0;i<N;i++){
            if(lis.size()==0||lis.get(lis.size()-1) < arr[i]){
                lis.add(arr[i]);
            }else{
                int left = 0;
                int right = lis.size()-1;

                while(left<right){
                    int mid = (left+right)/2;

                    if(lis.get(mid)<arr[i]){
                        mid = left+1;
                    }
                    else right = mid;
                }

                lis.set(left,arr[i]);
            }
        }

        System.out.println(lis.size());
    }

}
