import java.util.ArrayList;
import java.util.Scanner;

public class Ex_06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int degrees = Integer.parseInt(input.split("[()]+")[1]) % 360;

        ArrayList<String> inputLines = new ArrayList<>();
        int maxLength = 0;
        String inputLine = scanner.nextLine();
        while (!inputLine.equals("END")) {
            inputLines.add(inputLine);
            if (inputLine.length() > maxLength) {
                maxLength = inputLine.length();
            }
            inputLine = scanner.nextLine();
        }
        int rows = inputLines.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j < inputLines.get(i).length()) {
                    matrix[i][j] = inputLines.get(i).charAt(j);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }
        rotate(degrees, rows, cols, matrix);
    }

    private static void rotate(int degrees, int rows, int cols, char[][] matrix) {
        if (degrees == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees == 180) {
            for (int row = rows - 1; row >= 0 ; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees == 270) {
            for (int col = cols - 1; col >= 0 ; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}
