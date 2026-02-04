package day20260204;

import java.util.*;

public class ListTest {

    public static void main(String[] args){
        String[] temp = {"hello","world"};
        List<String> list = new ArrayList<>(Arrays.asList(temp));

        List<String> llist = new ArrayList<>();
        String[]arr = list.toArray(new String[list.size()]);

        String[] arrt2 = list.toArray(new String[list.size()]);

        List<String> list2 = new ArrayList<>(Arrays.asList(temp));

        List<Integer> lists = new ArrayList<>();

    }
}
