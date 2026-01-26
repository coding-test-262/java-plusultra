package day20260125;

import java.util.ArrayList;
import java.util.Scanner;

public class Backjoon11047 {
    static Scanner sc = new Scanner(System.in);
    static int N,K;
    static ArrayList<Integer> arrs = new ArrayList<>();

    private static void input(){
        N = sc.nextInt();
        K = sc.nextInt();

        for(int i=0;i<N;i++) {
            int num = sc.nextInt();
            arrs.add(num);
        }
    }

    private static void gameStart() {
        arrs.sort((a,b)->{
            return -1*(a-b);
        });

        int resultCount = 0;

        for(int i=0;i<N;i++){
            int money = arrs.get(i);
            resultCount += K/money;
            K%=money;
            if(K==0)break;
        }

        System.out.println(resultCount);

    }

    public static void main(String[] args) {
        input();
        gameStart();

    }
}
