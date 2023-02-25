import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][];

        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().toCharArray();
        }

        int food = 0;
        int snakeRow = -1;
        int snakeCol = -1;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                }
            }
        }

        while (true) {
            String direction = scanner.nextLine();
            field[snakeRow][snakeCol] = '.';

            if (direction.equals("up")) {
                snakeRow--;
                if (snakeRow >= 0) {
                    if (field[snakeRow][snakeCol] == '*') {
                        food++;
                    } else if (field[snakeRow][snakeCol] == 'B') {
                        field[snakeRow][snakeCol] = '.';
                        for (int row = 0; row < field.length; row++) {
                            for (int col = 0; col < field[row].length; col++) {
                                if (field[row][col] == 'B') {
                                    snakeRow = row;
                                    snakeCol = col;
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("Game over!");
                    break;
                }
            } else if (direction.equals("down")) {
                snakeRow++;
                if (snakeRow < n) {
                    if (field[snakeRow][snakeCol] == '*') {
                        food++;
                    } else if (field[snakeRow][snakeCol] == 'B') {
                        field[snakeRow][snakeCol] = '.';
                        for (int row = 0; row < field.length; row++) {
                            for (int col = 0; col < field[row].length; col++) {
                                if (field[row][col] == 'B') {
                                    snakeRow = row;
                                    snakeCol = col;
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("Game over!");
                    break;
                }
            } else if (direction.equals("left")) {
                snakeCol--;
                if (snakeCol >= 0) {
                    if (field[snakeRow][snakeCol] == '*') {
                        food++;
                    } else if (field[snakeRow][snakeCol] == 'B') {
                        field[snakeRow][snakeCol] = '.';
                        for (int row = 0; row < field.length; row++) {
                            for (int col = 0; col < field[row].length; col++) {
                                if (field[row][col] == 'B') {
                                    snakeRow = row;
                                    snakeCol = col;
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("Game over!");
                    break;
                }
            } else if (direction.equals("right")) {
                    snakeCol++;
                    if (snakeCol < n) {
                        if (field[snakeRow][snakeCol] == '*') {
                            food++;
                        } else if (field[snakeRow][snakeCol] == 'B') {
                            field[snakeRow][snakeCol] = '.';
                            for (int row = 0; row < field.length; row++) {
                                for (int col = 0; col < field[row].length; col++) {
                                    if (field[row][col] == 'B') {
                                        snakeRow = row;
                                        snakeCol = col;
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Game over!");
                        break;
                    }
                }
                if (food == 10) {
                    System.out.println("You won! You fed the snake.");
                    field[snakeRow][snakeCol] = 'S';
                    break;
                }
                field[snakeRow][snakeCol] = 'S';
        }
            System.out.println("Food eaten: " + food);
            for (int row = 0; row < field.length; row++) {
                for (int col = 0; col < field[row].length; col++) {
                    System.out.print(field[row][col]);
                }
                System.out.println();
            }
        }
    }

