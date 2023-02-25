import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab_04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> valuesWithTheirOccurrences = new LinkedHashMap<>();

        for (double value:input) {
            if (!valuesWithTheirOccurrences.containsKey(value)) {
            valuesWithTheirOccurrences.put(value, 1);
            } else {
                valuesWithTheirOccurrences.put(value, valuesWithTheirOccurrences.get(value) + 1);
            }
        }
        for (double value:valuesWithTheirOccurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", value, valuesWithTheirOccurrences.get(value));
        }
    }
}
