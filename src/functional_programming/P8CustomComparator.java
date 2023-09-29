package functional_programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P8CustomComparator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // comparator -> function accepts 2 parameters and return int(0, 1, -1)
        // 0 -> first == second
        // 1 -> first > second
        // -1 -> first < second

        // sorted(0) -> not swap the elements
        // sorted(1) -> swap the elements
        // sorted(-1) -> not swap the elements

        //  2 1 3 5 4 - > 2 4 1 3 5
        /*
           (2, 1) -> -1 не разменяме
           (1, 3) ->  -1 не разменяме
           (3, 5) -> -1 не разменяме
           (5, 4) -> 1 размяна (2 1 3 4 5)
           (2, 1) -> -1 не разменяме
           (1, 3) ->  -1 не разменяме
           (3, 4) -> 1 разменяме (2 1 4 3 5)
           (2, 1) -> -1 не разменяме
           (1, 4) -> 1 разменяме (2 4 1 3 5)
           (2, 4) ->  -1 не разменяме
           (4, 1) ->  -1 не разменяме
           (1, 3) ->  -1 не разменяме
           (3, 5) ->  -1 не разменяме
         */

        Comparator<Integer> customComparator = ((first, second) -> {
            // first even, second odd -> not swap
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            }
            // first odd, second even -> swap
            else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            }
            // first even, second even
            // first odd, second odd
            else {
                return first.compareTo(second);
            }
        });

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .sorted(customComparator)
              .forEach(e -> System.out.print(e + " "));
    }
}
