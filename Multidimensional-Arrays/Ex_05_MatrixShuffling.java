import java.util.Scanner;

public class Ex_05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String matrixSize = scanner.nextLine();
        int n = Integer.parseInt(matrixSize.split("\\s+")[0]);
        int m = Integer.parseInt(matrixSize.split("\\s+")[1]);

        String[][] matrix = new String[n][m];

        fillTheMatrix(matrix, scanner);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commandData = command.split("\\s+");
            if (command.startsWith("swap") && commandData.length == 5) {
                int firstIndex = Integer.parseInt(commandData[1]);
                int secondIndex = Integer.parseInt(commandData[2]);
                int thirdIndex = Integer.parseInt(commandData[3]);
                int forthIndex = Integer.parseInt(commandData[4]);
                if (firstIndex >= 0 && secondIndex >= 0 && thirdIndex >= 0 && forthIndex >= 0
                        && firstIndex <= matrix.length && secondIndex <= matrix.length && thirdIndex <= matrix.length && forthIndex <= matrix.length) {

                    String firstOneToSwap = matrix[firstIndex][secondIndex];
                    String secondOneToSwap = matrix[thirdIndex][forthIndex];
                    matrix[firstIndex][secondIndex] = secondOneToSwap;
                    matrix[thirdIndex][forthIndex] = firstOneToSwap;

                    printTheMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    private static void printTheMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillTheMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
    }
}
