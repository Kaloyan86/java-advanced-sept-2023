package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Stack - LIFO - Last in First out
        // push(element) - insert element on the top of the stack
        // pop() - remove topmost element
        // peek() - get topmost element

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(12);
        stack.push(25);
        stack.push(65);
        stack.push(4);

        //        while (!stack.isEmpty()) {
        //        System.out.println(stack.pop());
        //        }

        // Queue - FIFO - First in First out
        // offer(element) - add element at the start of the Queue
        // poll() - remove first element of the Queue
        // peek() - get first element of the Queue
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(12);
        queue.offer(25);
        queue.offer(65);
        queue.offer(4);

        //        while (!queue.isEmpty()) {
        //            System.out.println(queue.poll());
        //        }

        // PriorityQueue
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        priorityQueue.offer('1');
        priorityQueue.offer('2');
        priorityQueue.offer('3');
        priorityQueue.offer('4');
        priorityQueue.offer('5');

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}










