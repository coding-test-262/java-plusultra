package day20260125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Backjoon2839 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Vector<Integer> arrs = new Vector<>();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());
        arrs.setSize(5001);
        for(int i=0;i<=5000;i++){
            arrs.set(i,0);
        }
        arrs.set(0,0);

        for(int i=1;i<=N;i++){
            int min = Integer.MAX_VALUE;

            if(i-3>=0 && arrs.get(i-3)!=-1){
                min = Math.min(min, arrs.get(i-3)+1);
            }
            if(i-5>=0 && arrs.get(i-5)!=-1){
                min = Math.min(min, arrs.get(i-5)+1);
            }

            arrs.set(i, min==Integer.MAX_VALUE?-1:min);
        }

        System.out.println(arrs.get(N));
    }
}
