package day20260124;

import java.util.Scanner;

public class Backjoon1193 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        Pair pairs = findRow(N);
        String format = String.format("%d/%d", pairs.childNum, pairs.parentNum);
        System.out.println(format);

    }

    public static Pair findRow(int N) {
        int plusNum = 1;
        while(plusNum < N){
            N-=plusNum;
            plusNum++;
        }

        int sum = plusNum+1;

        if(plusNum%2==0){
            int parentNum = sum-N;
            int childNum = sum-parentNum;

            return new Pair(childNum,parentNum);
        }
        else{
            int childNum = sum-N;
            int parentNum = sum-childNum;

            return new Pair(childNum,parentNum);
        }

    }

    static class Pair{
        int childNum;
        int parentNum;

        Pair(int childNum, int parentNum) {
            this.childNum = childNum;
            this.parentNum = parentNum;
        }
    }
}
