import java.util.*;
import java.io.*;

public class Backjoon14888 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr;
    static int[] buho = new int[4];
    static int minNum = Integer.MAX_VALUE;
    static int maxNum = Integer.MIN_VALUE;

    static int calculateNum(int prevNum, int nowNum, int buho) {
        if (buho == 0) {
            return prevNum + nowNum;
        } else if (buho == 1) {
            return prevNum - nowNum;
        } else if (buho == 2) {
            return prevNum * nowNum;
        } else {
            return prevNum / nowNum;
        }
    }


    static void BackTracking(int prevNum, int idx) {
        if (idx == N) {
            minNum = Math.min(minNum, prevNum);
            maxNum = Math.max(maxNum, prevNum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (buho[i] == 0) continue;
            buho[i]--;

            int num = calculateNum(prevNum, arr[idx], i);
            BackTracking(num, idx + 1);

            buho[i]++;
        }
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            buho[i] = Integer.parseInt(st.nextToken());
        }

        BackTracking(arr[0], 1);

        System.out.println(maxNum);
        System.out.println(minNum);

    }
}
