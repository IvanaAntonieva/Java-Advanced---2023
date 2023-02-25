import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        int parisRow = -1;
        int parisCol = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'P') {
                    parisRow = i;
                    parisCol = j;
                }
            }
        }
        while (true) {
            String command = scanner.nextLine();
            String direction = command.split("\\s+")[0];
            int enemyRow = Integer.parseInt(command.split("\\s+")[1]);
            int enemyCol = Integer.parseInt(command.split("\\s+")[2]);
            matrix[parisRow][parisCol] = '-';
            matrix[enemyRow][enemyCol] = 'S';

            switch (direction) {
                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (parisRow + 1 < rows) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if (parisCol + 1 < matrix.length) {
                        parisCol++;
                    }
                    break;
            }
            energy--;
            if (energy <= 0) {
                parisIsDead(matrix, parisRow, parisCol);
                return;
            }
            if (matrix[parisRow][parisCol] == 'S') {
                energy -= 2;
                if (energy <= 0) {
                    parisIsDead(matrix, parisRow, parisCol);
                    return;
                } else {
                    matrix[parisRow][parisCol] = '-';
                }
            } else if (matrix[parisRow][parisCol] == 'H') {
                matrix[parisRow][parisCol] = '-';
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                printMatrix(matrix);
                return;
            }
        }
    }

    private static void parisIsDead(char[][] matrix, int row, int col) {
        matrix[row][col] = 'X';
        System.out.printf("Paris died at %d;%d.%n", row, col);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
