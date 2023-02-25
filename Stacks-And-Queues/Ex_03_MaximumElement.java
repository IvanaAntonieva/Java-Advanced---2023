import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Ex_03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();
            if (command.startsWith("1")) {
                int elementToPush = Integer.parseInt(command.split("\\s+")[1]);
                stack.push(elementToPush);
            } else if (command.equals("2")) {
                stack.pop();
            } else if (command.equals("3")) {
                if (!stack.isEmpty()) {
                    System.out.println(Collections.max(stack));
                }
            }
        }
    }
}
