import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrink {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String caffeine = scanner.nextLine();
        String energyDrinks = scanner.nextLine();
        int caffeineForTheDay = 0;

        Deque<Integer> caffeineStack = new ArrayDeque<>();
        Deque<Integer> energyDrinksQueue = new ArrayDeque<>();

        Arrays.stream(caffeine.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(caffeineStack::push);

        Arrays.stream(energyDrinks.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(energyDrinksQueue::offer);

        while (!caffeineStack.isEmpty() && !energyDrinksQueue.isEmpty()) {
            int currentDrink = energyDrinksQueue.peek();
            int mixture = caffeineStack.pop() * energyDrinksQueue.poll();
            if (mixture <= 300 - caffeineForTheDay) {
                caffeineForTheDay += mixture;
            } else {
                energyDrinksQueue.offer(currentDrink);
                caffeineForTheDay -= 30;
                if (caffeineForTheDay < 0) {
                    caffeineForTheDay = 0;
                }
            }
        }
        if (!energyDrinksQueue.isEmpty()) {
            System.out.print("Drinks left: ");
            System.out.println(energyDrinksQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", caffeineForTheDay);
    }
}
