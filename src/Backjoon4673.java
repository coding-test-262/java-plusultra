import java.util.Vector;

public class Backjoon4673 {

    static Vector<Boolean> arr = new Vector<>();
    public static void main(String[] args) {
        arr.setSize(10001);
        for (int i = 0; i <= 10000; i++) {
            arr.set(i, false);
        }
        for(int i=1;i<=10000;i++){
            if(arr.get(i)==true)continue;
            enrollDn(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=10000;i++){
            if(arr.get(i)==false){
                sb.append(i).append('\n');
            }

        }
        System.out.println(sb);
    }

    static void enrollDn(int num){
        while(num<=10000){
            num = calculate(num);
            if(num>10000)break;
            arr.set(num,true);

        }
    }

    static int calculate(int num){
        int result = num;
        while(num!=0){
            result += num%10;
            num/=10;
        }
        return result;
    }
}
