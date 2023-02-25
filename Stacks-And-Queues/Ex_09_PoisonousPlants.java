import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Ex_09_PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int[] plants = Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> plantsStack = new ArrayDeque<>();
        int[] days = new int[plants.length];
        plantsStack.push(0);
        for (int i = 1; i < plants.length; i++) {
            int maxDays = 0;

            while (plantsStack.size() > 0 && plants[plantsStack.peek()] >= plants[i]) {
                maxDays = Integer.max(days[plantsStack.pop()], maxDays);
            }
            if (plantsStack.size() > 0) {
                days[i] = maxDays + 1;
            }
            plantsStack.push(i);
        }
        System.out.printf("%d", Arrays.stream(days).max().getAsInt());
    }
}
