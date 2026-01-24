package day20260124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backjoon10814 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
            int age = Integer.parseInt(stringTokenizer.nextToken());
            String name = stringTokenizer.nextToken();

            persons.add(new Person(age,name,i));
        }

        persons.sort((p1,p2)->{
            if(p1.age==p2.age){
                return p1.registerAt - p2.registerAt;
            }
            return p1.age-p2.age;
        });

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<N;i++){
            stringBuilder.append(persons.get(i).age).append(' ').append(persons.get(i).name)
                    .append('\n');
        }

        System.out.println(stringBuilder);
    }

    static class Person{
        int age;
        String name;
        int registerAt;

        Person(int age, String name,int registerAt) {
            this.age = age;
            this.name = name;
            this.registerAt = registerAt;
        }
    }
}
