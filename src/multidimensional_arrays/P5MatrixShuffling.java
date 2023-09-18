package multidimensional_arrays;

import java.util.Scanner;

public class P5MatrixShuffling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        String line = scanner.nextLine();
        while (!"END".equals(line)) {
            String[] commandArgs = line.split("\\s+");

            if (!isValid(commandArgs, rows, cols)) {
                System.out.println("Invalid input!");
                line = scanner.nextLine();
                continue;
            }

            int row1 = Integer.parseInt(commandArgs[1]);
            int col1 = Integer.parseInt(commandArgs[2]);
            int row2 = Integer.parseInt(commandArgs[3]);
            int col2 = Integer.parseInt(commandArgs[4]);

            String temp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = temp;
            
            printMatrix(matrix);

            line = scanner.nextLine();
        }

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();
        }
    }

    private static boolean isValid(String[] commandArgs, int rows, int cols) {
        // For a command to be valid,
        // it should start with the "swap" keyword
        // along with four valid coordinates (no more, no less).
        if (commandArgs.length != 5) {
            return false;
        }

        String command = commandArgs[0];

        int row1 = Integer.parseInt(commandArgs[1]);
        int col1 = Integer.parseInt(commandArgs[2]);
        int row2 = Integer.parseInt(commandArgs[3]);
        int col2 = Integer.parseInt(commandArgs[4]);

        boolean areIndexesValid = row1 < rows && col1 < cols && row1 >= 0 && col1 >= 0 &&
                                  row2 < rows && col2 < cols && row2 >= 0 && col2 >= 0;

        return command.equals("swap") && areIndexesValid;
    }
}
