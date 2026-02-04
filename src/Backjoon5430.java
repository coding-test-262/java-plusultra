import java.io.*;
import java.util.*;

public class Backjoon5430 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();

            Deque<Integer> dq = parseArray(arrStr, n);

            boolean reversed = false;
            boolean error = false;

            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    reversed = !reversed;
                } else { // 'D'
                    if (dq.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (!reversed) dq.pollFirst();
                    else dq.pollLast();
                }
            }

            if (error) {
                output.append("error\n");
            } else {
                output.append(buildResult(dq, reversed)).append('\n');
            }
        }

        System.out.print(output);
    }

    // 문자열 "[1,2,3]" → Deque<Integer>
    private static Deque<Integer> parseArray(String arrStr, int n) {
        Deque<Integer> dq = new ArrayDeque<>();

        if (n == 0) return dq;

        String content = arrStr.substring(1, arrStr.length() - 1); // [ ]
        String[] nums = content.split(",");

        for (String num : nums) {
            dq.add(Integer.parseInt(num));
        }

        return dq;
    }

    // 결과 출력 문자열 생성
    private static String buildResult(Deque<Integer> dq, boolean reversed) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        while (!dq.isEmpty()) {
            sb.append(reversed ? dq.pollLast() : dq.pollFirst());
            if (!dq.isEmpty()) sb.append(',');
        }

        sb.append(']');
        return sb.toString();
    }
}
