import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] armory = new char[n][];
        for (int i = 0; i < armory.length; i++) {
            char[] row = scanner.nextLine().toCharArray();
            armory[i] = row;
        }

        int officerRow = -1;
        int officerCol = -1;

        for (int row = 0; row < armory.length; row++) {
            for (int col = 0; col < armory[row].length; col++) {
                if (armory[row][col] == 'A') {
                    officerRow = row;
                    officerCol = col;
                }
            }
        }

        int goldCoins = 0;

        //while (officerRow >= 0 && officerCol >= 0 && officerRow < armory.length && officerCol < armory.length && goldCoins < 65) {
        while (goldCoins < 65) {
            String direction = scanner.nextLine();
            armory[officerRow][officerCol] = '-';

            switch (direction) {
                case "up":
                        officerRow--;
                        if (officerRow >= 0) {
                        char currentChar = armory[officerRow][officerCol];
                        if (Character.isDigit(currentChar)) {
                            goldCoins += Character.getNumericValue(currentChar);
                            armory[officerRow][officerCol] = 'A';
                        } else if (currentChar == 'M') {
                            armory[officerRow][officerCol] = '-';
                            for (int row = 0; row < armory.length; row++) {
                                for (int col = 0; col < armory[row].length; col++) {
                                    if (armory[row][col] == 'M') {
                                        officerRow = row;
                                        officerCol = col;
                                        armory[officerRow][officerCol] = 'A';
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "down":
                        officerRow++;
                        if (officerRow < armory.length - 1) {
                        char currentChar = armory[officerRow][officerCol];
                        if (Character.isDigit(currentChar)) {
                            goldCoins += Character.getNumericValue(currentChar);
                            armory[officerRow][officerCol] = 'A';
                        } else if (currentChar == 'M') {
                            armory[officerRow][officerCol] = '-';
                            for (int row = 0; row < armory.length; row++) {
                                for (int col = 0; col < armory[row].length; col++) {
                                    if (armory[row][col] == 'M') {
                                        officerRow = row;
                                        officerCol = col;
                                        armory[officerRow][officerCol] = 'A';
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "left":
                        officerCol--;
                        if (officerCol > 0) {
                        char currentChar = armory[officerRow][officerCol];
                        if (Character.isDigit(currentChar)) {
                            goldCoins += Character.getNumericValue(currentChar);
                            armory[officerRow][officerCol] = 'A';
                        } else if (currentChar == 'M') {
                            armory[officerRow][officerCol] = '-';
                            for (int row = 0; row < armory.length; row++) {
                                for (int col = 0; col < armory[row].length; col++) {
                                    if (armory[row][col] == 'M') {
                                        officerRow = row;
                                        officerCol = col;
                                        armory[officerRow][officerCol] = 'A';
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "right":
                        officerCol++;
                        if (officerCol < armory.length - 1) {
                        char currentChar = armory[officerRow][officerCol];
                        if (Character.isDigit(currentChar)) {
                            goldCoins += Character.getNumericValue(currentChar);
                            armory[officerRow][officerCol] = 'A';
                        } else if (currentChar == 'M') {
                            armory[officerRow][officerCol] = '-';
                            for (int row = 0; row < armory.length; row++) {
                                for (int col = 0; col < armory[row].length; col++) {
                                    if (armory[row][col] == 'M') {
                                        officerRow = row;
                                        officerCol = col;
                                        armory[officerRow][officerCol] = 'A';
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
            if (officerRow < 0 && officerCol < 0 && officerRow >= armory.length && officerCol >= armory.length) {
                return;
                }
            }
        System.out.println("n");
        }
    }

