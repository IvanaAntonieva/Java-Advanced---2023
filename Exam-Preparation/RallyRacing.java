import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] route = new char[n][];

        String racingCar = scanner.nextLine();

        for (int row = 0; row < route.length; row++) {
            route[row] = scanner.nextLine().replace(" ", "").toCharArray();
        }

        int carRow = 0;
        int carCol = 0;
        int kilometersPassed = 0;

        String command = scanner.nextLine();
        while (!command.equals("End") && route[carRow][carCol] != 'F') {
            route[carRow][carCol] = '.';
            switch (command) {
                case "up":
                    carRow--;
                    kilometersPassed += 10;
                    if (route[carRow][carCol] == 'F') {
                        break;
                    }
                    if (route[carRow][carCol] == 'T') {
                        route[carRow][carCol] = '.';
                        kilometersPassed += 20;
                        for (int row = 0; row < route.length; row++) {
                            for (int col = 0; col < route[row].length; col++) {
                                if (route[row][col] == 'T') {
                                    carRow = row;
                                    carCol = col;
                                }
                            }
                        }
                    }
                    break;
                case "down":
                    carRow++;
                    kilometersPassed += 10;
                    if (route[carRow][carCol] == 'F') {
                        break;
                    }
                    if (route[carRow][carCol] == 'T') {
                        route[carRow][carCol] = '.';
                        kilometersPassed += 20;
                        for (int row = 0; row < route.length; row++) {
                            for (int col = 0; col < route[row].length; col++) {
                                if (route[row][col] == 'T') {
                                    carRow = row;
                                    carCol = col;
                                }
                            }
                        }
                    }
                    break;
                case "left":
                    carCol--;
                    kilometersPassed += 10;
                    if (route[carRow][carCol] == 'F') {
                        break;
                    }
                    if (route[carRow][carCol] == 'T') {
                        kilometersPassed += 20;
                        route[carRow][carCol] = '.';
                        for (int row = 0; row < route.length; row++) {
                            for (int col = 0; col < route[row].length; col++) {
                                if (route[row][col] == 'T') {
                                    carRow = row;
                                    carCol = col;
                                }
                            }
                        }
                    }
                    break;
                case "right":
                    carCol++;
                    kilometersPassed += 10;
                    if (route[carRow][carCol] == 'F') {
                        break;
                    }
                    if (route[carRow][carCol] == 'T') {
                        kilometersPassed += 20;
                        route[carRow][carCol] = '.';
                        for (int row = 0; row < route.length; row++) {
                            for (int col = 0; col < route[row].length; col++) {
                                if (route[row][col] == 'T') {
                                    carRow = row;
                                    carCol = col;
                                }
                            }
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        route[carRow][carCol] = 'C';
        if (command.equals("End")) {
            System.out.printf("Racing car %s DNF.%n", racingCar);
        } else {
            System.out.printf("Racing car %s finished the stage!%n", racingCar);
        }
        System.out.printf("Distance covered %d km.%n", kilometersPassed);
        for (int row = 0; row < route.length; row++) {
            for (int col = 0; col < route[row].length; col++) {
                System.out.print(route[row][col]);
            }
            System.out.println();
        }
    }
}
