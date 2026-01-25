import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Backjoon1764 {

    static int N,M;
    static HashMap<String, Integer> myMap = new HashMap<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader((System.in)));
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            String str = bf.readLine();
            myMap.put(str,1);
        }

        int resultCount = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> names = new ArrayList<>();
        for(int i=0;i<M;i++){
            String target = bf.readLine();
            if(myMap.containsKey(target)){
                names.add(target);
                resultCount++;
            }
        }

        names.sort(String::compareTo);

        System.out.println(resultCount);
        names.forEach(System.out::println);
    }
}
