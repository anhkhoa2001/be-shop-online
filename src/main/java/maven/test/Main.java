package maven.test;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=5; i++) {
            list.add(i);
        }

        for(Integer integer : list) {
            list1.add(integer);
        }
        list1.forEach(System.out::println);
    }
}
