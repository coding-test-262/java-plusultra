package day20260205;

import java.util.*;
import java.io.*;

public class Backjoon12100 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[][] arr;
    static int result = -1;

    private static void BackTracking(int count) {
        if (count == 5) {
            int maxNum = getMaxNum(arr);
            result = Math.max(maxNum, result);
            return;
        }
        int[][] copyArr = getCopyArr(arr);
        for (int i = 0; i < 4; i++) {

            moveBlock(i);
            BackTracking(count + 1);
            initArr(copyArr);
        }
    }

    private static void moveBlock(int i) {

        if(i==0){
            //북

            for(int garo=0;garo<N;garo++){
                Queue<Integer> myQueue = new ArrayDeque<>();
                for(int sero=0;sero<N;sero++){
                    myQueue.add(arr[sero][garo]);
                    arr[sero][garo] = 0;
                }
                Queue<Integer> mergedBlock = mergeBlock(myQueue);

                int idx = 0;
                while(!mergedBlock.isEmpty()){
                    int nowNum = mergedBlock.poll();
                    arr[idx++][garo] = nowNum;
                }
            }
        }
        else if (i==1){
            //동
            for(int sero=0;sero<N;sero++){
                Queue<Integer> myQueue = new ArrayDeque<>();
                for(int garo=N-1; garo>=0 ;garo--){
                    myQueue.add(arr[sero][garo]);
                    arr[sero][garo] = 0;
                }
                Queue<Integer> mergedBlock = mergeBlock(myQueue);

                int idx = N-1;
                while(!mergedBlock.isEmpty()){
                    int nowNum = mergedBlock.poll();
                    arr[sero][idx--] = nowNum;
                }
            }
        }
        else if (i==2){
            for(int garo=0;garo<N;garo++){
                Queue<Integer> myQueue = new ArrayDeque<>();
                for(int sero=N-1;sero>=0;sero--){
                    myQueue.add(arr[sero][garo]);
                    arr[sero][garo] = 0;
                }
                Queue<Integer> mergedBlock = mergeBlock(myQueue);

                int idx = N-1;
                while(!mergedBlock.isEmpty()){
                    int nowNum = mergedBlock.poll();
                    arr[idx--][garo] = nowNum;
                }
            }
        }
        else if (i==3){
            for(int sero=0;sero<N;sero++){
                Queue<Integer> myQueue = new ArrayDeque<>();
                for(int garo=0; garo<N; garo++){
                    myQueue.add(arr[sero][garo]);
                    arr[sero][garo] = 0;
                }
                Queue<Integer> mergedBlock = mergeBlock(myQueue);

                int idx = 0;
                while(!mergedBlock.isEmpty()){
                    int nowNum = mergedBlock.poll();
                    arr[sero][idx++] = nowNum;
                }
            }
        }
    }

    private static Queue<Integer> mergeBlock(Queue<Integer> myQueue) {
        Queue<Integer> mergeQueue = new ArrayDeque<>();
        ArrayList<Integer> lists = new ArrayList<>();

        while(!myQueue.isEmpty()){
            int num = myQueue.poll();
            if(num==0)continue;
            lists.add(num);
        }

        for(int i=0;i<lists.size();){
            if(i==lists.size()-1){
                mergeQueue.add(lists.get(i));
                break;
            }
            int firstNum = lists.get(i);
            int secondNum = lists.get(i+1);

            if(firstNum == secondNum){
                mergeQueue.add(firstNum*2);
                i=i+2;
            }
            else{
                mergeQueue.add(firstNum);
                i=i+1;
            }
        }

        return mergeQueue;
    }

    private static void initArr(int[][] copyArr) {
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                arr[i][k] = copyArr[i][k];
            }
        }
    }
    private static int getMaxNum(int[][] arr) {
        int num = -1;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                num = Math.max(num, arr[i][k]);
            }
        }
        return num;
    }
    private static int[][] getCopyArr(int[][] arr) {
        int[][] copyArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                copyArr[i][k] = arr[i][k];
            }
        }
        return copyArr;
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int k = 0; k < N; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        BackTracking(0);
        System.out.println(result);

    }
}
