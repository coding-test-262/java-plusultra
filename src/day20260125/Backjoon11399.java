package day20260125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backjoon11399 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader((System.in)));
    static ArrayList<Integer> arrs = new ArrayList<>();
    static int N;

    private static void Input() throws IOException {
        N = Integer.parseInt(bf.readLine());


        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arrs.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

    }

    private static void gameStart() {
        arrs.sort((a, b) -> {
            return a - b;
        });

        int sum = 0;
        int prevWaitTime = 0;
        for (int i = 0; i < N; i++) {
            prevWaitTime += arrs.get(i);
            sum += prevWaitTime;

        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        Input();
        gameStart();

    }
}
