package day20260124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Backjoon1181 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<String> strs = new ArrayList<>();
    static Set<String> mySet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++){
            String str = bf.readLine();
            mySet.add(str);
        }
        strs = new ArrayList<>(mySet);
        Collections.sort(strs, (a,b)->{
            if(a.length()!=b.length()){
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str).append('\n');
        }
        System.out.println(sb);
    }
}
