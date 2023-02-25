import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int size = Integer.parseInt(scanner.nextLine());
         String[][] matrix = new String[size][size];
         String[] directions = scanner.nextLine().split(",\\s+");

        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        int snakeRow = -1;
        int snakeCol = -1;
        int food = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j].equals("s")) {
                    snakeRow = i;
                    snakeCol = j;
                } else if (matrix[i][j].equals("f")) {
                     food += 1;
                }
            }
        }
        int length = 1;
        boolean isDead = false;
        for (String direction : directions) {
            matrix[snakeRow][snakeCol] = "*";
            switch (direction) {
                case "up":
                    snakeRow--;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
            }
            if (snakeRow < 0) {
                snakeRow = size - 1;
            }
            if (snakeRow >= size) {
                snakeRow = 0;
            }
            if (snakeCol < 0) {
                snakeCol = size - 1;
            }
            if (snakeCol >= size) {
                snakeCol = 0;
            }
            if (matrix[snakeRow][snakeCol].equals("f")) {
                length++;
                food--;
            }
            if (matrix[snakeRow][snakeCol].equals("e")) {
                isDead = true;
                break;
            }
            matrix[snakeRow][snakeCol] = "s";
        }
        if (food == 0) {
            System.out.println("You win! Final python length is " + length);
        } else if (isDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", food);
        }
    }
}
