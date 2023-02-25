import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Ex_04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<Character, Integer> symbols = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (!symbols.containsKey(symbol)) {
                symbols.get(symbol);
                symbols.put(symbol, 1);
            } else {
                int count = symbols.get(symbol);
                symbols.put(symbol, count + 1);
            }
        }
        symbols.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s"));
    }
}
