package day20260208;

import java.util.*;
import java.io.*;

public class Backjoon2866 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static ArrayList<String> strs = new ArrayList<>();

    public static void main(String[] args)throws Exception {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            String str = bf.readLine();
            strs.add(str);
        }


        int count = 0;
        int left = 1;
        int right = N-1;
        int answer = 0;
        while(left<=right){
            int mid = (left+right)/2;

            if(isCheck(mid)){
                left = mid+1;
                answer = mid;
            }else{
                right = mid-1;
            }
        }

        System.out.println(answer);

    }

    private static boolean isCheck(int startIdx) {
        HashSet<String> set = new HashSet<>();

        for (int k = 0; k < M; k++) {
            StringBuilder sb = new StringBuilder();
            for (int i = startIdx; i < N; i++) {
                sb.append(strs.get(i).charAt(k));
            }

            if (!set.add(sb.toString())) {
                return false;
            }
        }

        return true;
    }
}
