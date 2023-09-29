package functional_programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P2KnightsOfHonor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> appendSir = (s) -> System.out.println("Sir " + s);

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .forEach(appendSir);
    }
}
