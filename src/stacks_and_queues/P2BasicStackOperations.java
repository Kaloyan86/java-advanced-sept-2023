package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class P2BasicStackOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(tokens[0]);
        int s = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2]);

        Deque<Integer> stack = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                              .mapToInt(Integer::parseInt)
                              .toArray();
        // Add n elements to the stack
        for (int i = 0; i < n; i++) {
            stack.push(numbers[i]);
        }

        // Remove s elements from the stack
        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.isEmpty()){
            System.out.println(0); // check for empty stack
        }else if (stack.contains(x)){
            System.out.println(true); // Check if x is present in the stack
        }else {
            System.out.println(Collections.min(stack)); // get smallest element
        }

    }
}
