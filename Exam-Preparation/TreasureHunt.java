import java.util.*;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        char[][] map = new char[rows][];

        for (int i = 0; i < map.length; i++) {
            char[] row = scanner.nextLine().replace(" ", "").toCharArray();
            map[i] = row;
        }

        int currentRow = -1;
        int currentCol = -1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'Y') {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }

        List<String> path = new LinkedList<>();

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            switch (command) {
                case "up":
                    currentRow--;
                    if (goOutOfTheField(currentRow, currentCol, map) || stepOnATree(currentRow, currentCol, map)) {
                        currentRow++;
                    } else {
                        path.add(command);
                    }
                    break;
                case "down":
                    currentRow++;
                    if (goOutOfTheField(currentRow, currentCol, map) || stepOnATree(currentRow, currentCol, map)) {
                        currentRow--;
                    } else {
                        path.add(command);
                    }
                    break;
                case "left":
                        currentCol--;
                    if (goOutOfTheField(currentRow, currentCol, map) || stepOnATree(currentRow, currentCol, map)) {
                        currentCol++;
                    } else {
                        path.add(command);
                    }
                    break;
                case "right":
                        currentCol++;
                    if (goOutOfTheField(currentRow, currentCol, map) || stepOnATree(currentRow, currentCol, map)) {
                        currentCol--;
                    } else {
                        path.add(command);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        if (map[currentRow][currentCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", path));
        } else {
            System.out.println("The map is fake!");
        }
    }

    private static boolean stepOnATree(int currentRow, int currentCol, char[][] map) {
        if (map[currentRow][currentCol] == 'T') {
            return true;
        }
        return false;
    }

    private static boolean goOutOfTheField(int currentRow, int currentCol, char[][] map) {
        if (currentRow < 0 || currentRow >= map.length || currentCol < 0 || currentCol >= map[currentRow].length) {
            return true;
        }
        return false;
    }
}
