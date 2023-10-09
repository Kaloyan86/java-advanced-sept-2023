package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);

        List<Double> doubles = new ArrayList<>();
        doubles.add(5.5);

        List<Object> objectsList = new ArrayList<>();

        print(numbers);
        print(doubles);

        print2(objectsList);

    }

    static void print(List<? extends Number> list) {
        list.forEach(System.out::println);
    }

    static void print2(List<? super Number> list) {
        list.forEach(System.out::println);
    }
}
