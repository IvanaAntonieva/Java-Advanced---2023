import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab_06_PrintDiagonalsofSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];

        for (int i = 0; i < matrix.length; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = currentRow;
        }

        for (int i = 0; i < matrix.length; i++) {
                System.out.print(matrix[i][i] + " ");
                }
        System.out.println();
        for (int i = matrix.length - 1, j = 0; i >= 0; i--, j++) {
            System.out.print(matrix[i][j] + " ");
        }
    }
}
