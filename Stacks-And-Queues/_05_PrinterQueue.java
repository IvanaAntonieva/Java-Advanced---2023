import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!expression.equals("print")) {
            if (expression.equals("cancel")) {
                String output = queue.isEmpty()
                        ? "Printer is on standby"
                        : "Canceled " + queue.poll();
                System.out.println(output);
            } else {
                queue.offer(expression);
            }
            expression = scanner.nextLine();
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
//        for (String file:queue) {
//            System.out.println(file);
//        }
    }
}
