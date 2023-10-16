package exam_preparation;

import java.util.Scanner;

public class P2ThroneConqueringExamPrep16Oct23 {

    static int parisRow;
    static int parisCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][];

        int[] coordinates = fillMatrixAndGetCoordinates(field, scanner);
        parisRow = coordinates[0];
        parisCol = coordinates[1];
        field[parisRow][parisCol] = '-';

        while (energy > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            int spawnRow = Integer.parseInt(tokens[1]);
            int spawnCol = Integer.parseInt(tokens[2]);
            field[spawnRow][spawnCol] = 'S';

            move(command, field);

            energy -= 1;

            if (field[parisRow][parisCol] == 'S') {
                energy -= 2;
                // win the enemy
                if (energy > 0) {
                    field[parisRow][parisCol] = '-';
                }
            } else if (field[parisRow][parisCol] == 'H') {
                field[parisRow][parisCol] = '-';
                break;
            }
        }
        if (energy <= 0) {
            field[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
        } else {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n", energy);
        }
        printMatrix(field);
    }

    private static void move(String command, char[][] field) {
        switch (command) {
            case "up":
                if (canMove(field, parisRow - 1, parisCol)) {
                    parisRow -= 1;
                }
                break;
            case "down":
                if (canMove(field, parisRow + 1, parisCol)) {
                    parisRow += 1;
                }
                break;
            case "left":
                if (canMove(field, parisRow, parisCol - 1)) {
                    parisCol -= 1;
                }
                break;
            case "right":
                if (canMove(field, parisRow, parisCol + 1)) {
                    parisCol += 1;
                }
                break;
        }
    }

    private static boolean canMove(char[][] field, int parisRow, int parisCol) {

        return parisRow >= 0 && parisRow < field.length &&
               parisCol >= 0 && parisCol < field[parisRow].length;
    }

    private static void printMatrix(char[][] field) {
        for (char[] row : field) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static int[] fillMatrixAndGetCoordinates(char[][] field, Scanner scanner) {
        int[] coordinates = new int[2];

        for (int row = 0; row < field.length; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            field[row] = currentRow;

            // get Paris's coordinates
            for (int col = 0; col < currentRow.length; col++) {
                char symbol = currentRow[col];
                if (symbol == 'P') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
        return coordinates;
    }
}
