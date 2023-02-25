import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex_06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> map = new LinkedHashMap<>();

        String person = scanner.nextLine();
        while (!person.equals("stop")) {
            String email = scanner.nextLine();
            map.put(person, email);
            person = scanner.nextLine();
        }
        map.entrySet().removeIf(entry ->
                entry.getValue().endsWith("uk") || entry.getValue().endsWith("us") || entry.getValue().endsWith("com"));
        map.entrySet().forEach(entry ->
                System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
