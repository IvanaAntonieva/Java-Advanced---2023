import java.util.Scanner;

public class Lab_05_MaximumSumof2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] colData = scanner.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(colData[j]);
            }
        }
        int maxI = 0;
        int maxI1 = 0;
        int maxJ = 0;
        int maxJ1 = 0;
        int maxSum = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxI = i;
                    maxI1 = i + 1;
                    maxJ = j;
                    maxJ1 = j + 1;
                }
            }
        }
        System.out.println(matrix[maxI][maxJ] + " " + matrix[maxI][maxJ1]);
        System.out.println(matrix[maxI1][maxJ] + " " + matrix[maxI1][maxJ1]);
        System.out.println(maxSum);
    }
}
