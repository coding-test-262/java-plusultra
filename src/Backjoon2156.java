import java.util.ArrayList;
import java.util.Scanner;

public class Backjoon2156 {
    static int N;
    static int[] dp = new int[10001];
    static int[] arr = new int[10001];
    static Scanner sc = new Scanner(System.in);

    static int getMax(int a,int b,int c){
        int maxNum = Math.max(a,b);
        return Math.max(maxNum,c);
    }

    public static void main(String[] args) {
        N = sc.nextInt();

        for(int i=1;i<=N;i++){
            int num = sc.nextInt();
            arr[i] = num;
        }

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];


        for(int i=3;i<=N;i++){
           dp[i] =  getMax(arr[i]+arr[i-1]+dp[i-3], arr[i]+dp[i-2], dp[i-1]);

        }

        System.out.println(dp[N]);
    }
}
