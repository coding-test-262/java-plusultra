import java.io.*;
import java.util.*;

public class Backjoon2468 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    static void init() throws Exception {
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int k = 0; k < N; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int[][] copyArr() {
        int[][] copyArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                copyArr[i][k] = arr[i][k];
            }
        }
        return copyArr;
    }

    private static boolean isInside(int sero, int garo) {
        if (sero >= 0 && sero < N && garo >= 0 && garo < N) return true;
        return false;
    }

    static void BFS(int sero, int garo, boolean[][] visited, int[][] copyArr) {
        Queue<Node> myQueue = new ArrayDeque<>();
        myQueue.add(new Node(sero, garo));
        visited[sero][garo] = true;

        while (!myQueue.isEmpty()) {
            int y = myQueue.peek().y;
            int x = myQueue.peek().x;
            myQueue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (!isInside(ny, nx)) continue;
                if (visited[ny][nx]) continue;
                if (copyArr[ny][nx] == -1) continue;
                myQueue.add(new Node(ny, nx));
                visited[ny][nx] = true;
            }

        }
    }

    public static int rainArea(int depth) {
        int[][] copyArr = copyArr();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (copyArr[i][k] <= depth) {
                    copyArr[i][k] = -1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if(visited[i][k]|| copyArr[i][k]==-1)continue;
                BFS(i,k,visited, copyArr);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        init();

        int maxArea = -1;
        for (int i = 0; i <= 100; i++) {
            maxArea = Math.max(maxArea, rainArea(i));
        }

        System.out.println(maxArea);
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
