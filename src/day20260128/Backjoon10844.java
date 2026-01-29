package day20260128;

import java.util.*;
import java.io.*;

public class Backjoon10844 {
    static int N;
    static int [][]arr  = new int[101][10];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        N = sc.nextInt();

        for(int i=1;i<=9;i++){
            arr[1][i] = 1;
        }

        for(int i=2;i<=N;i++){

            for(int k=0;k<=9;k++){
                if(k==0){
                    arr[i][k] = arr[i-1][k+1];
                    continue;
                }
                if(k==9){
                    arr[i][k] = arr[i-1][k-1];
                    continue;
                }

                arr[i][k] = (arr[i-1][k-1]+arr[i-1][k+1])%1000000000;
            }
        }

        int resultSum = 0;
        for(int i=0;i<=9;i++){
            resultSum += arr[N][i];
            resultSum%=1000000000;
        }

        System.out.println(resultSum);
    }
}
