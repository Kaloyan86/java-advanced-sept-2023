package multidimensional_arrays;

import java.util.Scanner;

public class P2MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(tokens[0]);
        int c = Integer.parseInt(tokens[1]);

        String[][] matrix = new String[r][c];

        fillPalindromeMatrix(matrix);
        printMatrix(matrix);
    }

    private static void fillPalindromeMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char outsideSymbol = (char) ('a' + row);

                char midSymbol = (char) (outsideSymbol + col);

                matrix[row][col] = String.valueOf(new char[] {outsideSymbol, midSymbol, outsideSymbol});
            }
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
}
