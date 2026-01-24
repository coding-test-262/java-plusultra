import java.util.HashMap;
import java.util.Scanner;

public class Backjoon1316 {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int N = sc.nextInt();

        int count = 0;
        for(int i=0;i<N;i++){
            String str = sc.next();
            if(enroll(str)) count++;
            map.clear();
        }

        System.out.println(count);


    }

    private static boolean enroll(String str) {

        boolean newWord = false;
        char prevCh = '#';
        for (int i = 0; i < str.length(); i++) {
            char nowCh = str.charAt(i);
            if(map.containsKey(nowCh)){
            if(map.get(nowCh)==1 && prevCh!=nowCh) {
                return false;
            }
            }
            map.put(nowCh,1);
            prevCh = nowCh;
        }
        return true;
    }

}
