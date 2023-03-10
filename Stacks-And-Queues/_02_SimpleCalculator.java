import java.util.*;

public class _02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputParts = input.split("\\s+");
        Deque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, inputParts);

        while (stack.size() > 1) {
            int first = Integer.valueOf(stack.pop());
            String operation = stack.pop();
            int second = Integer.valueOf(stack.pop());

            switch (operation) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
                    break;
            }
        }
        System.out.println(stack.pop());
    }
}
