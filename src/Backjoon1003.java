import java.util.ArrayList;
import java.util.Scanner;

public class Backjoon1003 {
    static int T;
    static ArrayList<Node> arrs = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        T = sc.nextInt();

        for(int i=0;i<=40;i++){
            arrs.add(new Node(0,0));
        }

        arrs.set(0,new Node(1,0));
        arrs.set(1,new Node(0,1));

        for(int i=2;i<=40;i++){
            Node a = arrs.get(i-1);
            Node b = arrs.get(i-2);

            Node newNode = new Node(a.jeroCount + b.jeroCount, a.oneCount + b.oneCount);

            arrs.set(i,newNode);
        }


        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            Node result = arrs.get(N);
            System.out.println(result.jeroCount + " " + result.oneCount);

        }

    }

    static class Node{
        int jeroCount;
        int oneCount;

        public Node(int a, int b) {
            this.jeroCount=a;
            this.oneCount=b;
        }
    }
}
