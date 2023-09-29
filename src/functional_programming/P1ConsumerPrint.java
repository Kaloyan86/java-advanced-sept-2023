package functional_programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P1ConsumerPrint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> print = (s) -> System.out.println(s);

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .forEach(print);

    }
}
