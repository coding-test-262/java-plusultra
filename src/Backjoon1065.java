import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon1065 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static boolean[] arr = new boolean[1001];

    private static boolean checkHanSoo(String str) {
        int gap = 0;
        int prevGap = 0;
        boolean flag = true;
        for(int i=0;i<str.length()-1;i++){
            char first = str.charAt(i);
            char second = str.charAt(i+1);

            gap = first-second;
            if(i==0){
                prevGap = gap;
                continue;
            }
            else{
                if(prevGap!=gap){
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(bf.readLine());
    }

    private static void gameStart() {
        int num = 1;

        for(int i=1;i<=1000;i++){
            num = i;
            String str = String.valueOf(num);
            if(checkHanSoo(str))arr[i] = true;
            else arr[i] = false;
        }

        int resultCount = 0;

        for(int i=1;i<=N;i++){
            if(arr[i])resultCount++;
        }

        System.out.println(resultCount);
    }

    public static void main(String[] args) throws IOException {
        input();
        gameStart();
    }
}
