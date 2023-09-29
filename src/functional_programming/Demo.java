package functional_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Function<InputParam, ReturnType> -> use with apply
        Function<Integer, Integer> powerOf2Func = (a) -> a * a;
        Integer result = powerOf2Func.apply(5);

        //Consumer<InputParam> -> void -> use with accept
        Consumer<Integer> printNumberConsumer = (a) -> System.out.println(a);
        //        Consumer<Integer> printNumberConsumer = System.out::println;
        //        printNumberConsumer.accept(100);
        //Supplier<ReturnType> -> use with get
        Supplier<Scanner> getScannerSupplier = () -> new Scanner(System.in);
        //        Scanner scanner = getScannerSupplier.get();

        //Predicate<InputParam> -> return true / false -> use with test
        Predicate<Integer> isEvenPredicate = (n) -> n % 2 == 0;
        // boolean isEven = isEvenPredicate.test(5);

        //BiFunction<InputParam1, InputParam2, ReturnType> -> use with apply
        BiFunction<Integer, Integer, Integer> multiply2NumbersBiFunc = (a, b) -> a * b;
        multiply2NumbersBiFunc.apply(2,5);

        // 1 2 3 4 5 6 7 8 9 10
        Arrays.stream(getScannerSupplier.get().nextLine().split(" "))
              .map(Integer::parseInt)
              .map(powerOf2Func)
              .filter(isEvenPredicate)
              .forEach(printNumberConsumer);

        Map<Integer, Integer> map = Map.of(3, 5,
                                           5, 6,
                                           2, 4);

        powerOf2(7);

    }

    private static int powerOf2(int a) {
        return a * a;
    }

    private static void printNumber(int a) {
        System.out.println(a);
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static int b(int num1, int num2) {
        return num1 * num2;
    }
}
