package day20260204;

import java.util.*;

public class Solution2 {

    static Set<Integer> mySet = new HashSet<>();
    static int [] arr = {1,2,3,4,5};
    public static void main(String[] args){

        for(int i=0;i<arr.length;i++){
            mySet.add(arr[i]);
        }
    }
}
