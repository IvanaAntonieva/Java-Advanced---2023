import java.util.Scanner;

public class Lab_02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] colData = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(colData[j]);
            }
        }
        int searchedElement = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == searchedElement) {
                    isFound = true;
                    System.out.println(i + " " + j);
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
