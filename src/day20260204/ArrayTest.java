package day20260204;

import java.util.*;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arrs = {5,3,2,6,1,1,1,1,1};

        Arrays.sort(arrs);
        print(arrs);

        int[] uniqueArr = Arrays.stream(arrs)
                .distinct()
                .toArray();

        print(uniqueArr);

        int[] copyArr = Arrays.copyOfRange(arrs,2,3);
        print(copyArr);
    }

    private static void print(int[] arrs){
        for(int num : arrs){
            System.out.print(num);
            System.out.print(' ');
        }
        System.out.println();
    }
}
