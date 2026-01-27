package day20260128;

import java.util.Scanner;

public class Backjoon1929 {
    static int MAXSIZE = 1000000;
    static Scanner sc = new Scanner(System.in);
    static int N,M;
    static boolean[] isPrime = new boolean[MAXSIZE+1];


    private static void checkPrime(){
        for(int i=2;i<=MAXSIZE;i++){
            isPrime[i] = true;
        }

        for(int i=2;i*i<=MAXSIZE;i++){
            if(isPrime[i]){
                for(int k=i*i; k<=MAXSIZE;k+=i){
                    isPrime[k] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        checkPrime();

        for(int i=N;i<=M;i++){
            if(isPrime[i]){
                System.out.println(i);
            }
        }

    }
}
