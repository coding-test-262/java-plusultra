package day20260124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Backjoon2941 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, Integer> myMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String str = bf.readLine();
        myMap.put("c=", 1);
        myMap.put("c-", 1);
        myMap.put("dz=", 1);
        myMap.put("d-", 1);
        myMap.put("lj", 1);
        myMap.put("nj", 1);
        myMap.put("s=", 1);
        myMap.put("z=", 1);

        int resultCount = 0;

        for (int i = 0; i < str.length(); i++) {
            //검사하려는 단어가 d로시작하냐 안하냐
            if (str.charAt(i) == 'd') {
                if (i + 1 < str.length()) {
                    String newStr = str.substring(i, i + 2);
                    if (myMap.containsKey(newStr)) {
                        resultCount++;
                        i = i + 1;
                        continue;
                    }
                }
                if (i + 2 < str.length()) {
                    String newStr2 = str.substring(i, i + 3);
                    if (myMap.containsKey(newStr2)) {
                        resultCount++;
                        i = i + 2;
                        continue;
                    }
                }

            } else {
                if (i + 1 < str.length()) {
                    String newStr = str.substring(i, i + 2);
                    if (myMap.containsKey(newStr)) {
                        resultCount++;
                        i = i + 1;
                        continue;
                    }
                }

            }
            resultCount++;
        }
        System.out.println(resultCount);
    }
}
