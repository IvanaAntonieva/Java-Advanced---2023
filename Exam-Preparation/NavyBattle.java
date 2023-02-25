import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        
        fillMatrix(matrix, scanner);
        System.out.println();

        int subRow = -1;
        int subCol = -1;
        int countHits = 0;
        int countCruiser = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("S")) {
                    subRow = i;
                    subCol = j;
                }
            }
        }
        String command = scanner.nextLine();
        while (true) {

            matrix[subRow][subCol] = "-";
            if (command.equals("up")) {
                subRow--;
            } else if (command.equals("down")) {
                subRow++;
            } else if (command.equals("left")) {
                subCol--;
            } else if (command.equals("right")) {
                subCol++;
            }
            String subPosition = matrix[subRow][subCol];
            if (subPosition.equals("-")) {
                matrix[subRow][subCol] = "S";
            } else if (subPosition.equals("*")) {
                matrix[subRow][subCol] = "S";
                countHits++;
                if (countHits == 3) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", subRow, subCol);
                    break;
                }
            } else if (subPosition.equals("C")) {
                matrix[subRow][subCol] = "S";
                countCruiser++;
                if (countCruiser == 3) {
                    System.out.printf("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!%n");
                    break;
                }
            }
            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
                matrix[i] = scanner.nextLine().split("");
        }
    }
}
