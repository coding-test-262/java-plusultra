import java.util.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


public class StackTest {
    public static void main(String[] args) {
        Deque<Integer> myStack = new ArrayDeque<>();
        myStack.push(10);
        myStack.pop();
        myStack.peek();


        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.poll();
        queue.clear();
        queue.peek();

        PriorityQueue<Person> pq = new PriorityQueue<>(
                (p1,p2)->{
                    if(p1.age != p2.age){
                        return p1.age-p2.age;
                    }
                    else{
                        return p1.name.compareTo(p2.name);
                    }
                }
        );
    }

}
