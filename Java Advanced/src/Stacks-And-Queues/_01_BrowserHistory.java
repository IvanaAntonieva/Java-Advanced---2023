import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Deque<String> browserHistory = new ArrayDeque<>();

        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (browserHistory.isEmpty() || browserHistory.size() == 1) {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
                browserHistory.pop();
            } else {
                browserHistory.push(command);
            }
            System.out.println(browserHistory.peek());
            command = scanner.nextLine();
        }
    }
}
