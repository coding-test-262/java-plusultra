import java.util.*;
import java.io.*;

public class Backjoon1629 {
    static BufferedReader bc = new BufferedReader(new InputStreamReader(System.in));
    static long A,B,C;


    public static long half(long x){
        if(x==0)return 1;
        else if (x%2==1){
            return A*half(x-1)%C;
        }
        else{
            long halfNum = half(x/2);
            return halfNum*halfNum%C;
        }
    }



    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(bc.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(half(B));

    }
}
