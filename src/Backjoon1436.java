import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Backjoon1436 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());

        int num = 666;
        int count = 0;
        while(count!=N){
            if(String.valueOf(num).contains("666"))count++;
            if(count==N)break;
            num++;


        }

        System.out.println(num);
    }
}
