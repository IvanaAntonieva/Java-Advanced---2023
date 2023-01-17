import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (browserHistory.isEmpty() || browserHistory.size() == 1) {
                    System.out.println("no previous URLs");
                } else {
                    forwardHistory.push(browserHistory.pop());
                    System.out.println(browserHistory.peek());
                }
            } else if (command.equals("forward")) {
                if (forwardHistory.size() == 0) {
                    System.out.println("no next URLs");
                } else {
                    browserHistory.push(forwardHistory.peek());
                    System.out.println(forwardHistory.pop());
                }
            } else {
                forwardHistory.clear();
                System.out.println(command);
                browserHistory.push(command);
            }
            command = scanner.nextLine();
        }
    }
}
