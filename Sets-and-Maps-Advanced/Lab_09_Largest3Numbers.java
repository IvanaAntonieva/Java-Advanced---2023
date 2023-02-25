import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab_09_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> largestThreeNumbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        int maxSize = Math.min(largestThreeNumbers.size(), 3);
        for (int i = 0; i < maxSize; i++) {
            System.out.print(largestThreeNumbers.get(i) + " ");
        }
    }
}
