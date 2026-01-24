package day20260124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Backjoon11650 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Point> arrs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
            int x,y;
            x = Integer.parseInt(stringTokenizer.nextToken());
            y = Integer.parseInt(stringTokenizer.nextToken());

            arrs.add(new Point(x,y));
        }
        Collections.sort(arrs,(a,b)->{
            if(a.x==b.x){
                return a.y-b.y;
            }
            return a.x - b.x;
        });

        StringBuilder stringBuilder = new StringBuilder();
        for(Point arr: arrs){
            stringBuilder.append(arr.x).append(' ').append(arr.y).append('\n');
        }
        System.out.println(stringBuilder);
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;

        }
    }
}
