import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex_01_ReverseNumberWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputNumbers = input.split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String number : inputNumbers) {
            stack.push(number);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
