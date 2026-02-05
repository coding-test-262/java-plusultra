import java.util.*;
import java.io.*;

public class Backjoon2110 {
    static int N,C;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Integer[] arr;

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new Integer[N];
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(bf.readLine());
            arr[i] = num;
        }

        Arrays.sort(arr,(a,b)->{
            return a-b;
        });

        int left = 1;
        int right = arr[N-1] - arr[0];
        int answer = 0;
        while(left<=right){
            int mid = (left+right)/2;

            if(isCheck(mid)){
                left=mid+1;
                answer = Math.max(answer,mid);
            }else{
                right = mid-1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isCheck(int mid) {

        int cnt = 1;
        int last = arr[0];

        for(int i=1;i<N;i++){
            if(arr[i]-last >=mid){
                cnt++;
                last= arr[i];
            }

        }
        if(cnt>=C)return true;
        return false;
    }
}
