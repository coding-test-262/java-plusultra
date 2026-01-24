import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Backjoon2751 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> numbers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            numbers.add(num);

        }
        Collections.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for(int x : numbers){
            sb.append(x).append('\n');
        }
        System.out.println(sb);
    }
}
