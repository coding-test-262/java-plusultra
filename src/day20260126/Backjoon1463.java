package day20260126;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon1463 {

    static final int MAXSIZE = 1_000_000;
    static Queue<Node> myQueue = new ArrayDeque<>();
    static boolean[] visited = new boolean[MAXSIZE + 1];
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        myQueue.add(new Node(N, 0));
        visited[N] = true;

        while (!myQueue.isEmpty()) {
            Node node = myQueue.poll();

            int nowNum = node.num;
            int nowCount = node.count;

            if (nowNum == 1) {
                System.out.println(nowCount);
                return;
            }

            if (nowNum % 3 == 0) {
                int nextNum = nowNum / 3;
                if (!visited[nextNum]) {
                    visited[nextNum] = true;
                    myQueue.add(new Node(nextNum, nowCount + 1));
                }
            }

            if (nowNum % 2 == 0) {
                int nextNum = nowNum / 2;
                if (!visited[nextNum]) {
                    visited[nextNum] = true;
                    myQueue.add(new Node(nextNum, nowCount + 1));
                }
            }

            int nextNum = nowNum - 1;
            if (nextNum >= 1 && !visited[nextNum]) {
                visited[nextNum] = true;
                myQueue.add(new Node(nextNum, nowCount + 1));
            }
        }
    }

    static class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
