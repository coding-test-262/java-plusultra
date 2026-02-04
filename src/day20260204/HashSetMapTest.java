package day20260204;

import java.util.*;

public class HashSetMapTest {

    public static void main(String[] args){
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);

        set.contains(1);
        set.remove(1);
        set.size();

        HashMap<String, Integer> myMap = new HashMap<>();
        myMap.put("hello" , 1);
        myMap.put("world",2);
        myMap.put("java",3);

        myMap.get("hello");
        myMap.getOrDefault("photo",0);

        myMap.containsKey("hello");
        myMap.containsValue(3);

        for(Map.Entry<String,Integer> e : myMap.entrySet()){
            String key = e.getKey();
            Integer value = e.getValue();
        }


    }
}
