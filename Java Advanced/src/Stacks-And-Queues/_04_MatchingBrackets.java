import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                int startIndex = stack.pop();
                int endIndex = i;
                String subExpression = input.substring(startIndex, endIndex + 1);
                System.out.println(subExpression);
            }
        }
    }
}
