import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dims = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(dims[0]);
        int m = Integer.parseInt(dims[1]);

        char[][] field = new char[n][];

        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().replace(" ", "").toCharArray();
        }

        int myRow = -1;
        int myCol = -1;
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'B') {
                    myRow = row;
                    myCol = col;
                }
            }
        }
        int players = 0;
        int moves = 0;
        String command = scanner.nextLine();
        while (!command.equals("Finish") && players < 3) {
            switch (command) {
                case "up":
                    if (myRow > 0) {
                        int previousRow = myRow;
                        myRow--;
                      if (field[myRow][myCol] == 'P') {
                          moves++;
                          players++;
                          field[previousRow][myCol] = '-';
                      } else if (field[myRow][myCol] == 'O') {
                          myRow++;
                      } else if (field[myRow][myCol] == '-') {
                          moves++;
                          field[previousRow][myCol] = '-';
                      }
                      field[myRow][myCol] = 'B';
                    }
                    break;
                case "down":
                    if (myRow < n - 1) {
                        int previousRow = myRow;
                        myRow++;
                        if (field[myRow][myCol] == 'P') {
                            moves++;
                            players++;
                            field[previousRow][myCol] = '-';
                        } else if (field[myRow][myCol] == 'O') {
                            myRow--;
                        } else if (field[myRow][myCol] == '-') {
                            moves++;
                            field[previousRow][myCol] = '-';
                        }
                        field[myRow][myCol] = 'B';
                    }
                    break;
                case "left":
                    if (myCol > 0) {
                        int previousCol = myCol;
                        myCol--;
                        if (field[myRow][myCol] == 'P') {
                            moves++;
                            players++;
                            field[myRow][previousCol] = '-';
                        } else if (field[myRow][myCol] == 'O') {
                            myCol++;
                        } else if (field[myRow][myCol] == '-') {
                            moves++;
                            field[myRow][previousCol] = '-';
                        }
                        field[myRow][myCol] = 'B';
                    }
                    break;
                case "right":
                    if (myCol < m - 1) {
                        int previousCol = myCol;
                        myCol++;
                        if (field[myRow][myCol] == 'P') {
                            moves++;
                            players++;
                            field[myRow][previousCol] = '-';
                        } else if (field[myRow][myCol] == 'O') {
                            myCol--;
                        } else if (field[myRow][myCol] == '-') {
                            moves++;
                            field[myRow][previousCol] = '-';
                        }
                        field[myRow][myCol] = 'B';
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", players, moves);
    }
}
