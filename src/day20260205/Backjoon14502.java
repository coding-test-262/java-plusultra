package day20260205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon14502 {

    static class Node{
        int sero;
        int garo;

        public Node(int sero,int garo){
            this.sero = sero;
            this.garo = garo;
        }
    }
    static int[] dy = {0,-1,0,1};
    static int[] dx = {1,0,-1,0};

    static int N,M;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int[][] visited;
    static int resultCount = -1;

    private static void Back_Tracking(int idx, int count){
        if(count==3){
            //체크
            int [][] copyArr = getCopyArr(arr);
            BFS(copyArr);
            int saveAreaCount = getSafeAreaCount(copyArr);
            resultCount = Math.max(resultCount,saveAreaCount);
            return ;
        }

        for(int i=idx; i<N*M;i++){
            int sero = i/M;
            int garo = i%M;
            if(arr[sero][garo]==0){
                arr[sero][garo]=1;
                Back_Tracking(i+1,count+1);
                arr[sero][garo]=0;
            }

        }
    }

    private static void BFS(int sero,int garo, boolean[][] visited, int[][] copyArr){
        Queue<Node> myQueue = new ArrayDeque<>();
        myQueue.add(new Node(sero,garo));
        visited[sero][garo] = true;

        while(!myQueue.isEmpty()){
            int y = myQueue.peek().sero;
            int x = myQueue.peek().garo;
            myQueue.poll();

            for(int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(isInside(ny,nx)==false) continue;
                if(visited[ny][nx])continue;
                if(copyArr[ny][nx]==0){
                    myQueue.add(new Node(ny,nx));
                    visited[ny][nx]=true;
                }
            }
        }
    }

    private static int getSafeAreaCount(int[][] copyArr) {

        boolean[][] visited = new boolean[N][M];
        int count = 0;
        for(int i=0;i<N;i++){
            for(int k=0;k<M;k++){
                if( copyArr[i][k]==0){
                  count++;
                }
            }
        }
        return count;
    }

    private static boolean isInside(int sero,int garo){
        if(sero>=0&&sero<N && garo>=0&&garo<M)return true;
        return false;
    }

    private static void BFS(int[][] copyArr){
        Queue<Node> myQueue =new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int k=0;k<M;k++){
                if(copyArr[i][k]==2){
                    myQueue.add(new Node(i,k));
                    visited[i][k] = true;
                }
            }
        }

        while(!myQueue.isEmpty()){
            Node nowNode = myQueue.poll();
            int y = nowNode.sero;
            int x = nowNode.garo;

            for(int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(isInside(ny,nx)==false)continue;
                if(visited[ny][nx])continue;

                if(copyArr[ny][nx]==0){
                    myQueue.add(new Node(ny,nx));
                    visited[ny][nx] = true;
                    copyArr[ny][nx] = 2;
                }
            }
        }

    }

    private static int[][] getCopyArr(int[][] arr) {
        int[][] copyArr = new int[N][M];

        for(int i=0;i<N;i++){
            for(int k=0;k<M;k++){
                copyArr[i][k] = arr[i][k];
            }
        }

        return copyArr;
    }


    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int k=0;k<M;k++){
                arr[i][k] = Integer.parseInt(st.nextToken());

                if(arr[i][k]==2||arr[i][k]==1){
                    visited[i][k]= arr[i][k];
                }

            }
        }
        Back_Tracking(0,0);

        System.out.println(resultCount);


    }
}
