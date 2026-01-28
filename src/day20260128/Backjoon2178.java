package day20260128;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon2178 {
    static int N,M;
    static int [][] arr;
    static boolean [][] visited;
    static Scanner sc = new Scanner(System.in);
    static Queue<Node> myQueue = new ArrayDeque<>();
    static int[] dy = {0,-1,0,1};
    static int[] dx = {1,0,-1,0};


    static void init(){
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        arr = new int[N][M];
        visited=  new boolean[N][M];

        for(int i=0;i<N;i++){
            String str = sc.nextLine();
            for(int k=0;k<M;k++){
                arr[i][k] = str.charAt(k)-'0';
            }
        }
    }

    static void gameStart(){
        myQueue.add(new Node(0,0,1));
        visited[0][0] = true;

        while(!myQueue.isEmpty()){
            Node nowNode = myQueue.poll();
            int y = nowNode.y;
            int x = nowNode.x;
            int nowCount = nowNode.count;

            if(y==N-1 && x==M-1){
                System.out.println(nowCount);
                break;
            }

            for(int i=0;i<4;i++){
                int ny = y+dy[i];
                int nx = x + dx[i];
                if(isInside(ny,nx)==false)continue;
                if(visited[ny][nx])continue;
                if(arr[ny][nx]==1){
                    myQueue.add(new Node(ny,nx,nowCount+1));
                    visited[ny][nx] = true;
                }

            }
        }
    }

    static boolean isInside(int y,int x){
        if(y>=0&&y<N&&x>=0&&x<M)return true;
        return false;

    }

    public static void main(String[] args) {
        init();
        gameStart();
    }

    static class Node{
        int y;
        int x;
        int count;

        public Node(int y,int x, int count){
            this.y= y;
            this.x =x ;
            this.count = count;
        }
    }
}
