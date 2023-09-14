package stacks_and_queues;

import java.util.Scanner;

public class P6Fibonacci {

    private static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n + 1];
        long result = fib(n);

        System.out.println(result);
    }

    private static long fib(int n) {
        if (n < 2) {
            return 1;
        }
        if (memory[n] != 0) {
            return memory[n];
        }

        memory[n] = fib(n - 1) + fib(n - 2);
        return memory[n];
    }
}
