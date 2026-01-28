package day20260128;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon2667 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dy = {0,-1,0,1};
    static int[] dx = {1,0,-1,0};

    static class Node{
        int y;
        int x;

        public Node(int y,int x){
            this.y= y;
            this.x = x;
        }
    }
    static class ArrNode{
        int numbering;
        int count;

        public ArrNode(int numbering, int count) {
            this.numbering = numbering;
            this.count = count;
        }
    }

    static void init() {
        N = sc.nextInt();
        sc.nextLine();
        arr= new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String str = sc.nextLine();
            for(int k=0;k<str.length();k++){
                arr[i][k] = str.charAt(k)-'0';
            }
        }
    }

    static boolean isInside(int sero, int garo) {
        if(sero>=0&&sero<N &&garo>=0 &&garo<N)return true;
        return false;
    }

    static int numberingArr(int numbering, int sero,int garo){
        Queue<Node> myQueue = new ArrayDeque<>();
        myQueue.add(new Node(sero,garo));
        visited[sero][garo] = true;

        int numberingCount = 1;

        while(!myQueue.isEmpty()){
            Node nowNode = myQueue.poll();
            int y = nowNode.y;
            int x = nowNode.x;

            for(int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(isInside(ny,nx)==false)continue;
                if(visited[ny][nx])continue;
                if(arr[ny][nx]==1){
                    arr[ny][nx] = numbering;
                    visited[ny][nx] = true;
                    myQueue.add(new Node(ny,nx));
                    numberingCount++;
                }

            }
        }

        return numberingCount;
    }

    static void gameStart() {

        int numbering = 2;

        ArrayList<ArrNode> arrs = new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                if(!visited[i][k] && arr[i][k]==1){
                    int numberCount = numberingArr(numbering,i,k);
                    arrs.add(new ArrNode(numbering,numberCount));
                    numbering++;
                }
            }
        }

        arrs.sort((a,b)->{
            return a.count-b.count;
        });

        System.out.println(arrs.size());
        for(int i=0;i<arrs.size();i++){
            System.out.println(arrs.get(i).count);
        }
    }

    public static void main(String[] args) {
        init();
        gameStart();
    }


}
