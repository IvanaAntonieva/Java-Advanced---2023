import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab_03_Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        Set<Integer> secondPlayerCards = new LinkedHashSet<>();

        String[] inputOne = scanner.nextLine().split(" ");
        for (int i = 0; i < inputOne.length; i++) {
            int current = Integer.parseInt(inputOne[i]);
            firstPlayerCards.add(current);
        }
        String[] inputTwo = scanner.nextLine().split(" ");
        for (int i = 0; i < inputTwo.length; i++) {
            int current = Integer.parseInt(inputTwo[i]);
            secondPlayerCards.add(current);
        }

        for (int step = 0; step < 50; step++) {
            if (firstPlayerCards.isEmpty()) {
                break;
            } else if (secondPlayerCards.isEmpty()) {
                break;
            }

            Integer playerOne = firstPlayerCards.iterator().next();
            Integer playerTwo = secondPlayerCards.iterator().next();

            firstPlayerCards.remove(playerOne);
            secondPlayerCards.remove(playerTwo);

            if (playerOne > playerTwo) {
                firstPlayerCards.add(playerOne);
                firstPlayerCards.add(playerTwo);
            } else if (playerOne < playerTwo) {
                secondPlayerCards.add(playerOne);
                secondPlayerCards.add(playerTwo);
            }
        }

        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (firstPlayerCards.size() < secondPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
