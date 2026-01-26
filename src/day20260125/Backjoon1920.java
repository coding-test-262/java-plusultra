package day20260125;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Backjoon1920 {
    static Scanner sc = new Scanner(System.in);
    static int N,M;
    static ArrayList<Integer> A = new ArrayList<>();
    static ArrayList<Integer> B = new ArrayList<>();

    private static void input() {
        N = sc.nextInt();
        for(int i=0;i<N;i++){
            int num = sc.nextInt();
            A.add(num);
        }
        M = sc.nextInt();
        for(int i=0;i<M;i++){
            int num = sc.nextInt();
            B.add(num);
        }

    }

    private static void gameStart() {
        A.sort((a,b)->{
           return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int target = B.get(i);
            int idx = Collections.binarySearch(A,target);
            if(idx>=0){
                sb.append(1)
                        .append('\n');
            }
            else{
                sb.append(0)
                        .append('\n');
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        gameStart();
    }
}
