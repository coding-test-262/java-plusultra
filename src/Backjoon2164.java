import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon2164 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static Queue<Integer> myQueue = new ArrayDeque<>();

    public static void main(String[] args) {
        N = sc.nextInt();

        for(int i=1;i<=N;i++){
            myQueue.add(i);
        }

        while(myQueue.size()!=1){
            myQueue.poll();
            int second = myQueue.poll();
            myQueue.add(second);
        }

        System.out.println(myQueue.peek());

    }
}
