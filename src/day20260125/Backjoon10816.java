package day20260125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Backjoon10816 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static HashMap<Integer, Integer> myMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            myMap.put(num, myMap.getOrDefault(num,0)+1);
        }
        M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            if(myMap.containsKey(num)){
                sb.append(myMap.get(num))
                        .append(' ');
            }
            else{
                sb.append(0).append(' ');
            }

        }

        System.out.println(sb);

    }
}
