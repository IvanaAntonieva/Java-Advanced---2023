import java.util.*;
import java.util.stream.Collectors;

public class ApocalypsePreparation {
    public static final int PATCH_RESOURCE_NEEDED = 30;
    public static final int BANDAGE_RESOURCE_NEEDED = 40;
    public static final int MEDKIT_RESOURCE_NEEDED = 100;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String textiles = scanner.nextLine();
        String meds = scanner.nextLine();

        Deque<Integer> textileQueue = new ArrayDeque<>();
        Deque<Integer> medsStack = new ArrayDeque<>();

        fillTextileQueueAndMedsStack(textiles, meds, textileQueue, medsStack);

        Map<String, Integer> items = new HashMap<>();
        initializedItems(items);

        while (!textileQueue.isEmpty() && !medsStack.isEmpty()) {
            int healingItem = textileQueue.peek() + medsStack.peek();
            if (healingItem == PATCH_RESOURCE_NEEDED) {
                items.replace("Patch", items.get("Patch") + 1); textileQueue.poll(); medsStack.pop();
            } else if (healingItem == BANDAGE_RESOURCE_NEEDED) {
                items.replace("Bandage", items.get("Bandage") + 1); textileQueue.poll(); medsStack.pop();
            } else if (healingItem == MEDKIT_RESOURCE_NEEDED) {
                items.replace("MedKit", items.get("MedKit") + 1); textileQueue.poll(); medsStack.pop();
            } else if (healingItem > MEDKIT_RESOURCE_NEEDED) {
                items.replace("MedKit", items.get("MedKit") + 1); textileQueue.poll(); medsStack.pop();
                int nextMed = medsStack.peek();
                int newNextMed = nextMed + (healingItem - MEDKIT_RESOURCE_NEEDED);
                medsStack.pop();
                medsStack.push(newNextMed);
            } else {
                textileQueue.poll();
                int nextMed = medsStack.peek();
                int newNextMed = nextMed + 10;
                medsStack.pop();
                medsStack.push(newNextMed);
            }
        }

        if (textileQueue.isEmpty() && !medsStack.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if (medsStack.isEmpty() && !textileQueue.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else if (textileQueue.isEmpty() && medsStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        }

        LinkedHashMap<String, Integer> sortedItems = items.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (var entry : sortedItems.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }

        if (textileQueue.isEmpty() && !medsStack.isEmpty()) {
            System.out.print("Medicaments left: ");
            System.out.println(medsStack.toString().replaceAll("[\\[\\]]", ""));
        } else if (medsStack.isEmpty() && !textileQueue.isEmpty()) {
            System.out.print("Textiles left: ");
            System.out.println(textileQueue.toString().replaceAll("[\\[\\]]", ""));
        }
    }

    private static void initializedItems(Map<String, Integer> items) {
        items.put("Bandage", 0);
        items.put("Patch", 0);
        items.put("MedKit", 0);
    }

    private static void fillTextileQueueAndMedsStack(String textiles, String meds, Deque<Integer> textileQueue, Deque<Integer> medsStack) {
        Arrays.stream(textiles.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(textileQueue::offer);

        Arrays.stream(meds.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(medsStack::push);
    }
}
