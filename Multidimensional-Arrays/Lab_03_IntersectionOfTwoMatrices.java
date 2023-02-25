import java.util.Arrays;
import java.util.Scanner;

public class Lab_03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = new char[n][m];
        char[][] secondMatrix = new char[n][m];
        char[][] thirdMatrix = new char[n][m];

        for (int i = 0; i < n; i++) {
            firstMatrix[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        for (int i = 0; i < n; i++) {
            secondMatrix[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (firstMatrix[i][j] == secondMatrix[i][j]) {
                    thirdMatrix[i][j] = firstMatrix[i][j];
                } else {
                    thirdMatrix[i][j] = '*';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(thirdMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
