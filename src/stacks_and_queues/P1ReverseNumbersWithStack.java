package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P1ReverseNumbersWithStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

//        String[] input = scanner.nextLine().split("\\s+");
//
//        for (int i = 0; i < input.length; i++) {
//            int element = Integer.parseInt(input[i]);
//            stack.push(element);
//        }

        // Add elements to the stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .forEach(stack::push);

        // Remove elements from the stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
