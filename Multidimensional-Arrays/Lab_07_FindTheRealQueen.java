import java.util.Scanner;

public class Lab_07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][];
        for (int i = 0; i < 8; i++) {
            matrix[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        boolean isValidQueen = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrix[i][j] == 'q') {
                    int queenRow = i;
                    int queenCol = j;
                    if (isValidQueen) {
                        System.out.println(queenRow + " " + queenCol);
                    }
                }
            }
        }
    }
    public static boolean isValidQueen (char[][] matrix, int queenRow, int queenCol) {
        for (int i = 0; i < 8; i++) {
            if (matrix[i][queenRow] == 'q') {
                return false;
            } else if (matrix[queenCol][i] == 'q') {
                return false;
            }
        }
        return true;
    }
}
