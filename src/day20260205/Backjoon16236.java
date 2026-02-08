package day20260205;

import java.util.*;
import java.io.*;

public class Backjoon16236 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;
    static Fish fish;
    static int fishEatCount = 0;

    // (위, 왼, 오, 아래)로 두면 BFS 탐색 시 동률 처리에 유리
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    private static int game_Start() {
        int time = 0;

        while (true) {
            PriorityQueue<Fish> pq = getEatableFishQueue(fish.size);
            if (pq.isEmpty()) break;

            Fish eatableFish = pq.poll(); // 이미 "거리→위→왼" 정렬됨

            // 이동 시간 누적
            time += eatableFish.dist;

            // 먹기: 해당 칸 0으로 만들고 상어 위치 갱신
            arr[eatableFish.sero][eatableFish.garo] = 0;
            fish.sero = eatableFish.sero;
            fish.garo = eatableFish.garo;

            fishEatCount++;
            if (fishEatCount == fish.size) {
                fish.size++;
                fishEatCount = 0;
            }
        }

        return time;
    }

    private static boolean isInside(int sero, int garo) {
        return sero >= 0 && sero < N && garo >= 0 && garo < N;
    }

    // "먹을 수 있는 물고기"만 BFS로 찾아서 PQ에 넣음
    // 우선순위: dist 오름차순, sero 오름차순, garo 오름차순
    private static PriorityQueue<Fish> getEatableFishQueue(int size) {
        PriorityQueue<Fish> pq = new PriorityQueue<>((a, b) -> {
            if(a.dist!=b.dist) return a.dist- b.dist;
            if(a.sero!=b.sero) return a.sero - b.sero;
            return a.garo - b.garo;
        });

        int[][] dist = new int[N][N];
        for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                dist[i][k] = -1;
            }
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{fish.sero, fish.garo});
        dist[fish.sero][fish.garo] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (!isInside(ny, nx)) continue;
                if (dist[ny][nx] != -1) continue;

                // 지나갈 수 있는 칸: 0 또는 size 이하
                if (arr[ny][nx] > size) continue;

                dist[ny][nx] = dist[y][x]+1;
                q.add(new int[]{ny, nx});

                // 먹을 수 있는 물고기: 1 이상, size 미만
                if (arr[ny][nx] >= 1 && arr[ny][nx] < size) {
                    pq.add(new Fish(ny, nx, arr[ny][nx], dist[ny][nx]));
                }
            }
        }

        return pq;
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int k = 0; k < N; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
                if (arr[i][k] == 9) {
                    fish = new Fish(i, k, 2, 0);
                    arr[i][k] = 0; // 시작 위치는 빈칸 처리 (9는 지도에서 제거)
                }
            }
        }

        int answer = game_Start();
        System.out.println(answer);
    }

    static class Fish {
        int sero;
        int garo;
        int size; // 상어 size 또는 물고기 size로도 쓰이지만, 여기선 상어 size는 밖에서 관리
        int dist; // ★ BFS 최단거리

        public Fish(int sero, int garo, int size, int dist) {
            this.sero = sero;
            this.garo = garo;
            this.size = size;
            this.dist = dist;
        }
    }
}
