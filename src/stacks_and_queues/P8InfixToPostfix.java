package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class P8InfixToPostfix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String infix = scanner.nextLine();
        String[] tokens = infix.split("\\s+");

        Deque<String> postfix = getPostfix(tokens);

        while (!postfix.isEmpty()) {
            System.out.print(postfix.poll() + " ");
        }
    }

    private static Deque<String> getPostfix(String[] tokens) {
        List<String> operators = List.of("+", "-", "*", "/");

        // stack for the operators
        Deque<String> operatorStack = new ArrayDeque<>();
        // queue for the output
        Deque<String> outputQueue = new ArrayDeque<>();

        // Read each token in the infix expression from left to right
        for (String token : tokens) {
            // If the token is a number, add it to the output queue
            if (isNumber(token, operators)) {
                outputQueue.offer(token);

            } else if (operators.contains(token)) {
                // While there are operators on the operator stack,
                // and the operator on top of the stack has greater or equal precedence than the current operator,
                // pop the operator from the operator stack and add it to the output queue
                int precedence = getPrecedence(token);
                while (!operatorStack.isEmpty() && getPrecedence(operatorStack.peek()) >= precedence) {
                    outputQueue.offer(operatorStack.pop());
                }
                // Push the current operator to the operator stack.
                operatorStack.push(token);
            } else if (token.equals("(")) {
                // If the token is a left parenthesis, push it to the operator stack.
                operatorStack.push(token);
            } else if (token.equals(")")) {
                // If the token is a right parenthesis,
                // pop operators from the operator stack and add them to the output queue
                // until a left parenthesis is found
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    outputQueue.offer(operatorStack.pop());
                }
                // Remove the left parenthesis from the operator stack
                operatorStack.pop();
            }
        }
        // After all tokens have been read,
        // pop any remaining operators from the operator stack
        // and add them to the output queue
        while (!operatorStack.isEmpty()) {
            outputQueue.offer(operatorStack.pop());
        }

        return outputQueue;
    }

    private static int getPrecedence(String token) {
        switch (token) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "(":
            case ")":
                return -1;
            default:
                return 1;
        }
    }

    private static boolean isNumber(String token, List<String> operators) {
        return !operators.contains(token) && !(token.equals("(") || token.equals(")"));
    }
}
