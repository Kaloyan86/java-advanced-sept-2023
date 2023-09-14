package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P4BasicQueueOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(tokens[0]);
        int s = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2]);

        Deque<Integer> queue = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                              .mapToInt(Integer::parseInt)
                              .toArray();

        for (int i = 0; i < n; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(x)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(queue));
        }

    }
}
