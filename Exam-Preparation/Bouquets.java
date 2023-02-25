import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tulips = scanner.nextLine();
        String daffodils = scanner.nextLine();

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();

        Arrays.stream(tulips.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(tulipsStack::push);

        Arrays.stream(daffodils.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(daffodilsQueue::offer);

        int bouquets = 0;
        int leftFlowers = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int tulip = tulipsStack.peek();
            int daffodil = daffodilsQueue.peek();
            int sum = tulip + daffodil;
            if (sum == 15) {
                bouquets++;
                tulipsStack.pop();
                daffodilsQueue.poll();
            } else if (sum < 15) {
                leftFlowers += sum;
                tulipsStack.pop();
                daffodilsQueue.poll();
            } else if (sum > 15) {
                tulipsStack.pop();
                tulipsStack.push(tulip - 2);
            }
        }
        int bouquetsOfLeftFlowers = leftFlowers / 15;
        bouquets += bouquetsOfLeftFlowers;

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
