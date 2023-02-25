import java.util.*;

public class Ex_07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> players = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String person = input.split(": ")[0];
            String stringHands = input.split(": ")[1];
            String[] listHands = stringHands.split(", ");
            Set<String> hands = new LinkedHashSet<>();
            hands.addAll(Arrays.asList(listHands));
            if (!players.containsKey(person)) {
                players.put(person, hands);
            } else {
                Set<String> newHands = players.get(person);
                newHands.addAll(hands);
                players.put(person, newHands);
            }
            input = scanner.nextLine();
        }
        players.entrySet().forEach(entry -> {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int points = getCardPoints(cards);
                    System.out.printf("%s: %d%n", name, points);
                });
    }
    private static int getCardPoints(Set<String> cards) {
        Map<Character, Integer> symbolsValue = getSymbolsValue();
        int sumPoints = 0;
        for (String card : cards) {
            int points = 0;
            if (card.startsWith("10")) {
                char color = card.charAt(2);
                points = 10 * symbolsValue.get(color);
            } else {
                char power = card.charAt(0);
                char color = card.charAt(1);
                points = symbolsValue.get(power) * symbolsValue.get(color);
            }
        sumPoints += points;
        }
        return sumPoints;
    }

    private static Map<Character, Integer> getSymbolsValue() {
        Map<Character, Integer> characterValues = new HashMap<>();
        characterValues.put('2', 2);
        characterValues.put('3', 3);
        characterValues.put('4', 4);
        characterValues.put('5', 5);
        characterValues.put('6', 6);
        characterValues.put('7', 7);
        characterValues.put('8', 8);
        characterValues.put('9', 9);
        characterValues.put('J', 11);
        characterValues.put('Q', 12);
        characterValues.put('K', 13);
        characterValues.put('A', 14);
        characterValues.put('S', 4);
        characterValues.put('H', 3);
        characterValues.put('D', 2);
        characterValues.put('C', 1);
        return characterValues;
    }
}
