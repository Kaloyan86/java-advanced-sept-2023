package functional_programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P3CustomMinFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> findSmallestNumber = arr -> {
            return Arrays.stream(arr)
                         // .min((a, b) -> a.compareTo(b))
                         .min((a, b) -> Integer.compare(a, b))
                         .get();
        };    // 4 5 -2 3 -5 8

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                  .map(Integer::parseInt)
                                  .toArray(Integer[]::new);

        Integer smallestNumber = findSmallestNumber.apply(numbers);
        System.out.println(smallestNumber);
    }
}
