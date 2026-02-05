package day20260205;

import java.util.*;
import java.io.*;
import java.util.List;

public class Backjoon19238 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, oil;
    static int[][] arr;
    static int[] curTaxi = new int[2];
    static List<Point> persons = new ArrayList<>();
    static int[] dy ={0,-1,0,1};
    static int[] dx = {1,0,-1,0};

    static void init() throws Exception {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        oil = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int k = 0; k < N; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bf.readLine());
        curTaxi[0] = Integer.parseInt(st.nextToken()) -1;
        curTaxi[1] = Integer.parseInt(st.nextToken()) -1 ;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            persons.add(new Point(y1-1, x1-1, y2-1, x2-1));
        }
    }

    static boolean isInside(int sero, int garo) {
        if(sero>=0&&sero<N&&garo>=0&&garo<N)return true;
        return false;
    }

    static int[][] BFS(int sero,int garo){
        int[][] dist = new int[N][N];
        for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                dist[i][k] = -1;
            }
        }

        Queue<qNode> myQueue = new ArrayDeque<>();
        myQueue.add(new qNode(sero,garo));
        dist[sero][garo] = 0;

        while(!myQueue.isEmpty()){
            qNode node = myQueue.poll();
            int y = node.y;
            int x = node.x;

            for(int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(isInside(ny,nx)==false) continue;
                if(dist[ny][nx]!=-1)continue;
                if(arr[ny][nx]==1) continue;
                dist[ny][nx] = dist[y][x] +1;
                myQueue.add(new qNode(ny,nx));

            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        init();

        while (true) {
            int[][] dist = BFS(curTaxi[0], curTaxi[1]);
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
                if (a.dist != b.dist) return a.dist - b.dist;
                if (a.sero != b.sero) return a.sero - b.sero;
                return a.garo - b.garo;
            });

            for(int i=0;i<persons.size();i++){
                int y = persons.get(i).y1;
                int x = persons.get(i).x1;
                int ny = persons.get(i).y2;
                int nx = persons.get(i).x2;
                if (dist[y][x] == -1) continue;
                pq.add(new Node(y,x,dist[y][x],ny,nx));
            }
            if(pq.isEmpty())break;
            Node nowNode = pq.poll();
            curTaxi[0] = nowNode.sero;
            curTaxi[1] = nowNode.garo;
            oil -= nowNode.dist;

            int[][] nextDist =  BFS(curTaxi[0], curTaxi[1]);
            int d2 = nextDist[nowNode.nextSero][nowNode.nextGaro];
            if (d2 == -1) { System.out.println(-1); return; }

            curTaxi[0] = nowNode.nextSero;
            curTaxi[1] = nowNode.nextGaro;
            oil -= nextDist[nowNode.nextSero][nowNode.nextGaro];

            if(oil <0){
                System.out.println(-1);
                return;
            }
            else{
                oil += nextDist[nowNode.nextSero][nowNode.nextGaro]*2;

            }
            initPersonsList(pq);

            if(persons.size()==0){
                System.out.println(oil);
                return;
            }

        }

    }

    private static void initPersonsList(PriorityQueue<Node> pq) {
        persons.clear();
        while(!pq.isEmpty()){
            Node node = pq.poll();
            persons.add(new Point(node.sero,node.garo, node.nextSero,node.nextGaro));
        }
    }

    static class Point {
        int y1;
        int x1;
        int y2;
        int x2;

        public Point(int y1, int x1, int y2, int x2) {
            this.y1 = y1;
            this.x1 = x1;
            this.y2 = y2;
            this.x2 = x2;
        }
    }

    static class Node {
        int sero;
        int garo;
        int dist;

        int nextSero;
        int nextGaro;

        public Node(int a, int b, int c, int e, int f) {
            sero = a;
            garo = b;
            dist = c;
            nextSero = e;
            nextGaro = f;
        }
    }
    static class qNode{
        int y;
        int x;

        public qNode(int y,int x){
            this.y = y;
            this.x = x;

        }
    }
}
