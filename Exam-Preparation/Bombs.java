import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bombEffects = scanner.nextLine();
        String bombCasings = scanner.nextLine();

        Deque<Integer> effectsQueue = new ArrayDeque<>();
        Deque<Integer> casingsStack = new ArrayDeque<>();

        Arrays.stream(bombEffects.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(effectsQueue::offer);

        Arrays.stream(bombCasings.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(casingsStack::push);

        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;

        while (!(daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) && !effectsQueue.isEmpty() && !casingsStack.isEmpty()) {
            int currentBomb = effectsQueue.peek() + casingsStack.peek();
            switch (currentBomb) {
                case 40:
                    daturaBombs++; effectsQueue.poll(); casingsStack.pop();
                    break;
                case 60:
                    cherryBombs++; effectsQueue.poll(); casingsStack.pop();
                    break;
                case 120:
                    smokeDecoyBombs++; effectsQueue.poll(); casingsStack.pop();
                    break;
                default:
                    int currentCasing = casingsStack.peek();
                    casingsStack.pop();
                    casingsStack.push(currentCasing - 5);
                    break;
            }
        }
        if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (effectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " + effectsQueue.toString().replaceAll("[\\[\\]]", ""));
        }
        if (casingsStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: " + casingsStack.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.println("Cherry Bombs: " + cherryBombs);
        System.out.println("Datura Bombs: " + daturaBombs);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBombs);
    }
}
