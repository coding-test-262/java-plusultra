package day20260208;

import java.io.*;
import java.util.*;

class Backjoon28707 {

    static BufferedReader br;
    static BufferedWriter bw;

    static class Command implements Comparable<Command>{
        int a, b, c;

        public Command(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Command o) {
            return this.b - o.b;
        }
    }

    static int N, M;
    static int[] input;
    static int start, end;
    static Command[] commands;

    static void solve() throws IOException {
        Map<Integer, Integer> dist = new HashMap<>();
        PriorityQueue<Command> pq = new PriorityQueue<>();
        pq.add(new Command(start, 0, 0));
        dist.put(start, 0);
        while(!pq.isEmpty()) {
            Command cur = pq.poll();

            if (dist.containsKey(cur.a) && dist.get(cur.a) < cur.b) continue;

            // 커멘드 모두 적용
            for (int i = 0; i < M; i++) {
                int nNode = adjustWithCommand(cur.a, i);
                int nDist = cur.b + commands[i].c;

                if (dist.containsKey(nNode) && dist.get(nNode) <= nDist) continue;
                pq.add(new Command(nNode, nDist, 0));
                dist.put(nNode, nDist);
            }
        }

        // 결과 출력
        if (dist.containsKey(end)) {
            bw.write(dist.get(end) + "\n");
        } else {
            bw.write("-1\n");
        }
        bw.flush();
    }

    // 배열을 십진법 수로 변환
    static int arrayToInteger(int[] arr) {
        int result = 0;
        int mult = 1;
        for (int i = N-1; i >= 0; i--) {
            result += mult * arr[i];
            mult *= 10;
        }
        return result;
    }

    // 숫자에 대해 특정 커멘드 적용
    static int adjustWithCommand(int target, int ind) {
        Command command = commands[ind];
        int aMult = (int)Math.pow(10, N - 1 - command.a);
        int bMult = (int)Math.pow(10, N - 1 - command.b);
        int aNum = target/aMult%10*aMult;
        int bNum = target/bMult%10*bMult;
        target -= (aNum + bNum);
        target += (aNum/aMult*bMult + bNum/bMult*aMult);
        return target;
    }

    public static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken()) - 1;
        M = Integer.parseInt(br.readLine());
        commands = new Command[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            commands[i] = new Command(a, b, c);
        }
        start = arrayToInteger(input);
        Arrays.sort(input);
        end = arrayToInteger(input);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}