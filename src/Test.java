import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        HashMap<Integer, Integer> test = new HashMap<>();
        PriorityQueue<Integer>[] pq = new PriorityQueue[2];


        System.out.println(test.get(1) == null);

    }

}

class AImpl implements A{

}

interface A {

}

class B {

    static A a = new AImpl();



}

/*
1 = 1
2 = 8
3 = 27
4 = 64
5 = 125
6 = 216


 */