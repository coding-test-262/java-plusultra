package day20260208;

import java.util.*;

public class Backjoon2143 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n = sc.nextInt();
        int[] A = new int[n];

        for(int i=0;i<n;i++) A[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] B = new int[m];

        for(int i=0;i<m;i++) B[i] = sc.nextInt();

        ArrayList<Integer> subA = getAllSubSums(A);
        ArrayList<Integer> subB = getAllSubSums(B);

        HashMap<Integer, Integer> mapB = new HashMap<>();
        for(int num : subB){
            mapB.put(num, mapB.getOrDefault(num,0)+1);
        }

        long answer = 0;
        for(int num: subA){
            answer+= mapB.getOrDefault(T-num,0);
        }
        System.out.println(answer);
    }

    private static ArrayList<Integer> getAllSubSums(int[] a) {
        ArrayList<Integer >lists = new ArrayList<Integer>();

        for(int i=0;i<a.length;i++){
            int sum = 0;
            for(int k=i; k<a.length;k++){
                sum+= a[k];
                lists.add(sum);
            }
        }
        return lists;
    }
}
