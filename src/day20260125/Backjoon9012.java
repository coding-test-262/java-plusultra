package day20260125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Backjoon9012 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Character> myStack = new Stack<>();

    private static void GameStart(int N) throws IOException {

        for(int i=0;i<N;i++){
            myStack.clear();
            String str = bf.readLine();
            if(checkLine(str)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }

    private static boolean checkLine(String str){
        for(int i=0;i<str.length();i++){

            char ch = str.charAt(i);
            if(ch=='('){
                myStack.push(ch);
            }
            else if (ch==')'){
                if(myStack.isEmpty()){
                    myStack.push(ch);
                    continue;
                }
                char topCh = myStack.peek();
                if(topCh=='('){
                    myStack.pop();

                }
                else if(topCh==')'){
                    myStack.push(ch);
                }
            }
        }

        if(!myStack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());

        GameStart(N);
    }
}
