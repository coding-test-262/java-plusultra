import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Backjoon1427 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        long num = Long.parseLong(bf.readLine());

        while(num!=0){
            arr.add(num%10);
            num/=10;
        }
        arr.sort((a,b)->{
            return -Long.compare(a,b);
        });

        StringBuilder stringBuilder = new StringBuilder();
        for(Long n : arr){
            stringBuilder.append(n);
        }
        System.out.println(stringBuilder);

    }
}
