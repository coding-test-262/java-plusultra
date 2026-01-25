import java.util.Scanner;
import java.util.Stack;

public class Backjoon10733 {
    static Scanner sc = new Scanner(System.in);
    static int K;
    static Stack<Integer> myStack = new Stack<>();

    public static void main(String[] args) {
        K = sc.nextInt();
        for(int i=0;i<K;i++){
            int num = sc.nextInt();
            if(num==0){
                if(myStack.empty())continue;
                myStack.pop();
                continue;
            }

            myStack.push(num);
        }

        int resultSum = 0;
        while(!myStack.isEmpty()){
            resultSum += myStack.pop();
        }

        System.out.println(resultSum);
    }
}
