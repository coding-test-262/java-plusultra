package day20260208;

import java.util.*;
import java.io.*;

public class Backjoon4195 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent, size;
    static int T;
    static int N;

    private static int find(int a){
        if(parent[a]== a)return parent[a];
        return parent[a] = find(parent[a]);
    }

    private static int union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b){
            parent[b] = a;
            size[a] += size[b];
        }
        return size[a];
    }

    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(bf.readLine());

        for(int i=0;i<T;i++){
            HashMap<String,Integer> myMap = new HashMap<>();
            N = Integer.parseInt(bf.readLine());
            parent = new int[2*N+1];
            size = new int[2*N+1];

            for(int c=1;c<=2*N;c++){
                parent[c]=c;
                size[c] = 1;
            }
            int idx = 1;
            for(int k=0;k<N;k++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if(!myMap.containsKey(a)) myMap.put(a, idx++);
                if(!myMap.containsKey(b))myMap.put(b,idx++);
                int res = union(myMap.get(a),myMap.get(b));
                System.out.println(res);
            }


        }
    }

}
