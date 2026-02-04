

public class StringBuilderTest {

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();


        sb.setLength(0);
        System.out.println(sb);
        sb.append("Dong ho");
        System.out.println(sb);
        sb.delete(0,1); //ong ho
        System.out.println(sb);
        sb.deleteCharAt(2); // on ho
        System.out.println(sb);
        sb.reverse(); // oh no
        System.out.println(sb);
        sb.setCharAt(0,'F');//Fh no
        System.out.println(sb);
        sb.setLength(3); //Fh
        System.out.println(sb);
        String str2 = sb.toString();
        System.out.println(
                str2
        );

    }
}
