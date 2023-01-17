import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _03_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        if (number == 0) {
            System.out.println("0");
            return;
        }

        while (number != 0) {
            int bit = number % 2;
            stack.push(bit);
            number /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
