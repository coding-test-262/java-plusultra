import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon1697 {
    static Scanner sc = new Scanner(System.in);
    static int N,M;

    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        Queue<Node> myQueue = new ArrayDeque<>();
        myQueue.add(new Node(N,0));
        visited[N] = true;

        while(!myQueue.isEmpty()){
            int nowPoint = myQueue.peek().point;
            int nowCount = myQueue.peek().count;
            myQueue.poll();
            if(nowPoint == M){
                System.out.println(nowCount);
                break;
            }


            extracted(nowPoint, myQueue, nowCount);
            int nextPoint;

            nextPoint = nowPoint +1;
            if(isInside(nextPoint)&&visited[nextPoint]==false){
                myQueue.add(new Node(nextPoint,nowCount+1));
                visited[nextPoint] = true;
            }

            nextPoint = nowPoint*2;
            if(isInside(nextPoint)&&visited[nextPoint]==false){
                myQueue.add(new Node(nextPoint,nowCount+1));
                visited[nextPoint] = true;
            }


        }

    }

    private static void extracted(int nowPoint, Queue<Node> myQueue, int nowCount) {
        int nextPoint = nowPoint -1;
        if(isInside(nextPoint)&&visited[nextPoint]==false){
            myQueue.add(new Node(nextPoint, nowCount +1));
            visited[nextPoint] = true;
        }
    }

    static boolean isInside(int point){
        if(point>=0&&point<=100000)return true;
        return false;
    }

    static class Node{
        int point;
        int count;

        public Node(int point,int count) {
            this.point = point;
            this.count = count;
        }
    }
}
