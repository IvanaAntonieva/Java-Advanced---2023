import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex_05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String person = input.split("-")[0];
            String number = input.split("-")[1];
            phonebook.put(person, number);
            input = scanner.nextLine();
        }
        String searchedPerson = scanner.nextLine();
        while (!searchedPerson.equals("stop")) {
            if (!phonebook.containsKey(searchedPerson)) {
                System.out.printf("Contact %s does not exist.%n", searchedPerson);
            } else {
                System.out.println(searchedPerson + " -> "+ phonebook.get(searchedPerson));
            }
            searchedPerson = scanner.nextLine();
        }
    }
}
