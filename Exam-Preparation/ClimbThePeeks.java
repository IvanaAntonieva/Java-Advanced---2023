import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeeks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String foodPortions = scanner.nextLine();
        String stamina = scanner.nextLine();

        Deque<Integer> foodStack = new ArrayDeque<>();
        Deque<Integer> staminaQueue = new ArrayDeque<>();

        Arrays.stream(foodPortions.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(foodStack::push);

        Arrays.stream(stamina.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(staminaQueue::offer);

        Deque<String> peaks = new ArrayDeque<>(Arrays.asList("Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza"));
        Map<String, Integer> peakAndLevel = new LinkedHashMap<>(Map.of("Vihren", 80, "Kutelo", 90,
                                            "Banski Suhodol", 100, "Polezhan", 60, "Kamenitza", 70));
        List<String> conqueredPeaks = new ArrayList<>();

        while (!peakAndLevel.isEmpty() && !foodStack.isEmpty() && !staminaQueue.isEmpty()) {
            int combination = foodStack.pop() + staminaQueue.poll();
            String currentPeak = peaks.getFirst();
            if (combination >= peakAndLevel.get(currentPeak)) {
                conqueredPeaks.add(currentPeak);
                peaks.remove(currentPeak);
                peakAndLevel.remove(currentPeak);
            }
        }
        if (peakAndLevel.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            System.out.println(conqueredPeaks.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
        }
    }
}
