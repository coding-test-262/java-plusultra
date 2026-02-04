package day20260204;

import java.util.*;

public class DoubleArrTest {

    public static void main(String[] args){
        int[][] arrs = new int[][]{
            {5,4},
            {2,2}
        };

        Arrays.sort(arrs, (a,b)->{

            for(int i=0;i<Math.min(a.length, b.length); i++){
                if(a[i]!=b[i])return a[i]-b[i];
            }
            return a.length - b.length;
        });

        for(int i=0;i<2;i++){
            for(int k=0;k<2;k++){
                System.out.print(arrs[i][k]);
                System.out.print(' ');
            }
            System.out.println();
        }

    }
}
